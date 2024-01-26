package src;

import java.util.HashMap;
import java.util.Map;

public class Database {

    static Map<String, String> teachersMap = new HashMap<>();
    public static void starterTeachersDatabase() {
        teachersMap.put("125377443411", "Yesim, Akbag, 1980, Matematik");
        teachersMap.put("121234587412", "Veli, Denli, 1981, Fizik");
        teachersMap.put("127659877413", "Ayse, Yesil, 1982, Kimya");
        teachersMap.put("134657667414", "Mehmet, Can, 1983, Kimya");
        teachersMap.put("198765437415", "Alp, Can, 1984, Matematik");
    }

    static Map<String, String> studentsMap = new HashMap<>();
    public static void starterStudentsDatabase() {
        studentsMap.put("469922399405", "Ali, Can, 2008, 3569, 12, A");
        studentsMap.put("165776787406", "Hikmet, Ran, 2008, 3559, 12, B");
        studentsMap.put("143244487408", "Ayse, Can, 2007, 4569, 12, A");
        studentsMap.put("648643787403", "Ahmet, Yesil, 2009, 1569, 11, A");
        studentsMap.put("124366967407", "Zehra, Kara, 2009, 3769, 11, A");
    }


}
