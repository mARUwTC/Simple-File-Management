import java.io.File;
import java.util.Scanner;

public class FileManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter md/dir/rd/del/exit");
        String prefix = null;
        String suffix = null;

        while (!input.hasNext("exit")){

            String[] cmd = input.nextLine().split(" ");
            prefix = cmd[0];
            if (cmd.length > 1) suffix = cmd[1];
            else suffix = ".";

            while (true) {
                if (prefix.equals("md")) {
                    File file = new File (suffix);
                    if (file.mkdirs()) {
                        System.out.println("Directory is created!");
                    } else {
                        System.out.println("Not success!");
                    }
                    break;
                }
                else if (prefix.equals("dir")) {
                    File dir = new File(suffix);
                    System.out.println("Start of directory");
                    String[] dirs = dir.list();
                    for (int i = 0; i < dirs.length; i++) {
                        System.out.println(dirs[i]);
                    }
                    System.out.println("End of directory");
                    break;
                }
                else if (prefix.equals("rd")) {
                    File dir = new File (suffix);
                    if (dir.delete()){
                        System.out.println("Directory is deleted!");
                    } else {
                        System.out.println("Not success!");
                    }
                    break;
                }
                else if (prefix.equals("del")) {
                    File file = new File(suffix);
                    if (file.delete()) {
                        System.out.println("Deleted the file: " + file.getName());
                    } else {
                        System.out.println("Not success!");
                    }
                    break;
                }
            }
        }
    }
}