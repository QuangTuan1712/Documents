
public enum Locations {
	STREET {
		@Override
		public String toString() {
			return "on the street";
		}
	},
	DOOR {
		@Override
		public String toString() {
			return "";
		}
	},
	STORE {
		@Override
		public String toString() {
			return "the store";
		}
	},
	STAND {
		@Override
		public String toString() {
			return "On special wooden stands";
		}
	},
	COUNTER {
		@Override
		public String toString() {
			return "On the counter";
		}
	},
	SHOWCASES {
		@Override
		public String toString() {
			return "In these showcases";
		}
	},
	SHOWCASE {
		@Override
		public String toString() {
			return "In this showcase";
		}
	},
	WALL {
		@Override
		public String toString() {
			return "along the walls";
		}
	},
}
