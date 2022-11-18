import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("album1","Alan Walker");
        album1.addSong("Song 1",5.2);
        album1.addSong("Song 2",4.5);
        album1.addSong("Song 3",3.5);
        album1.addSong("Song 4",3.5);
        album1.addSong("Song 5",3.5);
        album1.addSong("Song 6",3.5);

        LinkedList<Song> myPlaylist  = new LinkedList<>();
        album1.addToPlayList("Song 1",myPlaylist);
        album1.addToPlayList("Song 2",myPlaylist);
        album1.addToPlayList("Song 3",myPlaylist);
        album1.addToPlayList("Song 4",myPlaylist);
        album1.addToPlayList("Song 5",myPlaylist);

        play(myPlaylist);
    }

    public static void play(LinkedList<Song> playList){

        Scanner sc = new Scanner(System.in);
        ListIterator<Song> itr = playList.listIterator();
        if(!itr.hasNext()){
            System.out.println("Playlist is empty");
            return;
        }

        System.out.println("You are now listening " + itr.next());
        showMenu();
        boolean forward = true;
        while(true)
        {
            int option = sc.nextInt();

            switch(option)
            {
                case 0:
                    System.out.println("Thank you for listening");
                    return;

                case 1:
                    showMenu();
                    break;
                case 2:
                    printList(playList);
                    break;
                case 3: if(forward == false)//pehle previous dabaya tha
                        {
                            itr.next();
                        }
                        if(itr.hasNext() == false) System.out.println("There is no next song");
                        else System.out.println("You are now listening to " + itr.next());
                        forward = true;
                        break;
                case 4: if(forward == true)
                        {
                            itr.previous();
                        }
                        if(itr.hasPrevious() == false) System.out.println("There is no previous song");
                        else System.out.println("You are now listening to " + itr.previous());
                        forward = false;
                        break;
                case 5: if(playList.size() == 0)
                {
                    System.out.println("Playlist is empty");
                   // showMenu();
                    break;
                }
                    if(forward == false)//pehle previous dabaya tha
                        {
                            itr.next();
                        }
                        System.out.println("You are again listening to " + itr.previous());
                        if(forward == true) itr.next();
                        break;
                case 6:if(playList.size() == 0)
                {
                    System.out.println("Playlist is empty");
                    showMenu();
                    break;
                }
                    System.out.println("which song you want to delete ?");
                    printList(playList);
                    System.out.println("0: Exit");
                    int op = sc.nextInt();
                   if(op == 0)
                   {
                       System.out.println("Thank you for listening");
                       return;
                   }
                   else
                   {
                       ListIterator<Song> del = playList.listIterator();
                       int count = 0;
                       while(count != op)
                       {
                           del.next();
                           count++;
                       }
                       System.out.println("song " + op + " is deleted");
                       del.remove();
                       System.out.println("now your playlist is:");
                       printList(playList);
                       System.out.println("6. delete another song");
                       System.out.println("0. Exit");
                       break;
                      // System.out.println("do you want to delete any other song?");
                   }

            }
        }
    }

    public static void printList(LinkedList<Song> playList){
        if(playList.size() == 0)
        {
            System.out.println("Playlist is empty");
            // showMenu();
            return;
        }
        ListIterator<Song> itr = playList.listIterator();
        int i = 1;
        while(itr.hasNext()){
            System.out.println(i + ": "  + itr.next());
            i++;
        }
        return;
    }

    public static void showMenu(){

        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all Songs in the playlist");
        System.out.println("3. Play next song");
        System.out.println("4. Play previous Song");
        System.out.println("5. Repeat the song");
        System.out.println("6. Delete the song");

    }
}