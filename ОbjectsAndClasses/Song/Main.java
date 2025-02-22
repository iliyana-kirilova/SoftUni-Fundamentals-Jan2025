package Week7_objectsAndClasses.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songsCollection = new ArrayList<>();

        for (int i = 1; i <=countSongs ; i++) {
            String input = scanner.nextLine();
            String[] data = input.split("_");

            String typeList = data[0];
            String name = data[1];
            String time = data[2];

            Song song = new Song(typeList,name, time);
            songsCollection.add(song);

        }
        String command = scanner.nextLine();

        if (command.equals("all")){
            for (Song song : songsCollection) {
                System.out.println(song.getName());

            }
        } else {
            for (Song song : songsCollection) {
                if (song.getTypeList().equals(command)){
                    System.out.println(song.getName());
                }
            }
        }

    }
}
