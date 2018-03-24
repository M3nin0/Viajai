package model;

public class Local {

	public String trataLocal(String local) {
		
		switch  (local) {
		case "Igreja":
			local = "church";
			break;
		case "Academia":
			local = "gym";
			break;
		case "Bar":
			local = "bar";
			break;
		case "Universidade":
			local = "university";
			break;
		case "Hospital":
			local = "hospital";
			break;
		default:
			local = "N/A";
			break;
	
		}
		return local;

	}
	
}
