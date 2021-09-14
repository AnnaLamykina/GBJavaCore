import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("loading.csv");
        ArrayList<DataFile> dataFiles = new ArrayList<>();
        System.out.println("Загрузка данных из файла");

        try(BufferedReader in = new BufferedReader(new FileReader(file))){
            String result = null;
            in.readLine();
            while ((result = in.readLine()) != null) {
                String[] elem = result.split(";");
                dataFiles.add(new DataFile(elem[0], Integer.parseInt(elem[1])));
            }
        }
        for (DataFile dataFile: dataFiles){

            System.out.println(dataFile.getName() + " " + dataFile.getAge());
        }

        AppData app=new AppData(new String[]{"value1","value2","value3"},new int[][]{{1,2,3},{4,5,6}});
        System.out.println("Данные сохраненные в файл");
        app.write();

    }




    public static class DataFile {
        private String name;
        private int age;

    public DataFile (String name, int age)     {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

    public static class AppData {

        private final String[] header;
        private final int[][] data;


    public AppData (String[] header, int[][] data)  {
        this.header = header;
        this.data = data;




    }



    public void write() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("save.csv"))) {
                for (String str:header) {
                    writer.write(str+";");
                }

                writer.write("\n");
//                for(int i=0;i< data.length;i++){
//                    int[] elem=data[i];
//                    for(int j=0;j< elem.length;j++){
//                        writer.write(elem[j]+";");
//                    }
//                    writer.write("\n");
//                }
                for (int[] i:data){
                    for (int j:i){
                        writer.write(j+";");
                    }
                    writer.write("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedReader reader = new BufferedReader(new FileReader("save.csv"))) {
                String str;
                while ((str = reader.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }}
