public class Stringpars {
    static public void main(String[] args){
        String sqlString = "SELECT * FRom students WHERE ";
        String personInfo = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}";
        String[] perList = personInfo.split(", ");
        StringBuilder resultSQL = new StringBuilder();
        resultSQL.append(sqlString);
        String and = " AND ";
        int step = 1;
        for (String elem : perList){
            elem = elem.replace("}", "").replace("{", "");
            String[] perData = elem.split(":");
            String notIn = perData[1].replace("'", "");
            if (!notIn.equals("null")){
                if (step > 1){
                    resultSQL.append(and);
                    resultSQL.append(perData[0].replace("'", "")+"="+perData[1]);
                }
                else{
                    resultSQL.append(perData[0].replace("'", "")+"="+perData[1]);
                }
            }
            step++;
        }
        System.out.println(resultSQL);
    }
}
