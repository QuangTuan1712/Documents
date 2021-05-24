package t1u7a1n2;

import t1u7a1n2.commands.*;
import t1u7a1n2.flat.*;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * Class to deal with input and output and manage CollectionManager class instance.
 */
public class Manager {
	private String filename;
	private CollectionManager collectionManager;
	
	/**
	 * @param filename the path to file from which we read and to which we write collection data
	 */
	public Manager(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Method to start a new collection and System.in reader
	 */
	public void start() {
		Parser parser = new Parser();
		try {
			File f = new File(filename);
			if(!f.isDirectory() && Files.isReadable(f.toPath())) {
				collectionManager = parser.fromJsonToCollectionManager(parser.fromFileToString(filename));
			}else {
				System.out.println("There is no rights for reading file. Change rights and run program again!");
                System.exit(0);
			}
		}
		catch (NullPointerException | IOException e) {
            System.out.println("File path is wrong. Run program again with correct filename.");
            System.exit(0);
		}
		
		Map<String, Command> commandMap = new HashMap<>();
		commandMap.put("help", new HelpCommand(commandMap));
		commandMap.put("info", new InfoCommand(collectionManager));
		commandMap.put("show", new ShowCommand(collectionManager, parser));
		commandMap.put("add", new AddCommand(collectionManager));
		commandMap.put("update", new UpdateIDCommand(collectionManager));
		commandMap.put("remove_by_id", new RemoveByIDCommand(collectionManager));
		commandMap.put("clear", new ClearCommand(collectionManager));
		commandMap.put("save", new SaveCommand(collectionManager, parser, filename));
		commandMap.put("remove_head", new RemoveHeadCommand(collectionManager, parser));
		commandMap.put("remove_greater", new RemoveGreaterCommand(collectionManager));
		commandMap.put("remove_lower", new RemoveLowerCommand(collectionManager));
		commandMap.put("sum_of_number_of_rooms", new SumOfNumberOfRoomsCommand(collectionManager));
		commandMap.put("max_by_creation_date", new MaxByCreationDateCommand(collectionManager, parser));
		commandMap.put("group_counting_by_name", new GroupCountingByNameCommand(collectionManager));
		try {
			terminal(parser, commandMap, "no file", 0);
		} catch (IOException e) {
			throw new InvalidArgumentsException("You have entered wrong file name. Try the command again.");
		}
	}
	
	/**
     * @param parser     Parser instance
     * @param commandMap Map of all commands from string command to Command instance
     * @param filename   file to execute script
     * @param level      recursion level
     * @throws IOException throws if file has a wrong name
     */
    public void terminal(Parser parser, Map<String, Command> commandMap, String filename, int level) throws IOException {
        if (level > 15) {
            System.out.println("You can't execute file recursively more then 15 times! You are not in execute script anymore!");
            level = 0;
            filename = "no file";
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File f = new File(filename);
        if (f.exists()) {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        }

        while (true) {
            try {
                System.out.print("> ");
                String readLine = br.readLine();
                String[] line = cleanLine(readLine.split("[ \t\f]+"));
                if (line.length > 0) {
                    if (commandMap.containsKey(line[0])) {
                        Command command = commandMap.get(line[0]);
                        command.setArgs(line);
                        boolean commandIsReady = true;
                        if (command instanceof ElementNeed) {
                            commandIsReady = false;
                            boolean exit = false;
                            while (!exit) {
                                try {
                                    Flat element = new Flat();
                                    System.out.println("You run a command, which needs Flat element to be entered.");

                                    System.out.println("Enter element's name.");
                                    element.setName(br.readLine());

                                    System.out.println("Enter coordinates.");
                                    element.setCoordinates(new Coordinates(Long.valueOf(br.readLine()), Double.parseDouble(br.readLine())));

                                    System.out.println("Enter area.");
                                    element.setArea(Long.valueOf(br.readLine()));

                                    System.out.println("Enter number of rooms.");
	                                element.setNumberOfRooms(Long.parseLong(br.readLine()));
	                                
                                    System.out.println("Enter one furnish of following list.");
                                    for (Furnish furnish: Furnish.values()) {
                                    	System.out.print(furnish.toString());
                                    }
                                    
                                    element.setFurnish(br.readLine());
                                    
                                    System.out.println("Enter one view of following list:");
                                    for (View view : View.values()) {
                                        System.out.print(view.toString() + "; ");
                                    }

                                    element.setView(br.readLine());

                                    System.out.println("Enter one transport of following list:");
                                    for (Transport transport : Transport.values()) {
                                        System.out.print(transport.toString() + "; ");
                                    }

                                    element.setTransport(br.readLine());
                                    
                                    System.out.println("Enter house parametrs:");
                                    House house = new House();
                                    System.out.println("Enter name.");
                                    house.setName(br.readLine());
                                    System.out.println("Enter year.");
                                    house.setYear(Integer.parseInt(br.readLine()));
                                    System.out.println("Enter number of lifts.");
                                    house.setNumberOfLifts(Long.parseLong(br.readLine()));
                                    element.setHouse(house);
                                    ((ElementNeed) command).setFlatElement(element);
                                    commandIsReady = true;
                                    exit = true;
                                } catch (InvalidArgumentsException e) {
                                    System.out.println("You have entered invalidate value." + e.getMessage() + "\nDo you want to exit from command? (yes/no)");
                                    if (br.readLine().equals("yes") && !filename.equals("no file")) {
                                        exit = true;
                                        commandIsReady = false;
                                        System.out.println("You have exit from previous command.");
                                    } else {
                                        System.out.println("Try again.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("You have entered wrong type value." + "\nDo you want to exit from command? (yes/no)");
                                    if (br.readLine().equals("yes") || !filename.equals("no file")) {
                                        exit = true;
                                        commandIsReady = false;
                                        System.out.println("You have exit from previous command.");
                                    } else {
                                        System.out.println("Try again.");
                                    }
                                }
                            }
                        }
                        if (commandIsReady) {
                            System.out.println(command.run());
                        }
                    } else if (line[0].equals("exit")) {
                        break;
                    } else if (line[0].equals("execute_script")) {
                        if (line.length != 2) {
                            System.out.println("execute_script have the only argument - filename.");
                        } else {
                            terminal(parser, commandMap, line[1], level + 1);
                        }
                    } else {
                        System.out.println("There is no such command.");
                    }
                }
            } catch (InvalidArgumentsException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("You have entered the end of file symbol. Program will be terminate and collection will be saved.");
                commandMap.get("save").setArgs(new String[]{"save"});
                commandMap.get("save").run();
                System.exit(0);
            }
        }
    }
    
    private String[] cleanLine(String[] line) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : line) {
            if (!s.equals("")) {
                result.add(s);
            }
        }
        String[] resultStr = new String[result.size()];
        return result.toArray(resultStr);
    }
}
