import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    //find
    public boolean findSong(String title)
    {
        for(Song checkSong: this.songs)
        {
            if(checkSong.getTitle().equals(title)){
                System.out.println("Song Found !!");
                return true;
            }
        }

        return false;
    }

    //add Song
    public boolean addSong(String title, double duration)
    {
        if(findSong(title)==true) {
            System.out.println("SOng already present");
            return false;
        }
        // add
        songs.add(new Song(title,duration));
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){

       for(Song checkedSong: this.songs){
           if(checkedSong.getTitle().equals(title)){
               playList.add(checkedSong);
               return true;
           }
       }
       return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber-1;
        if(index>=0 && index<=this.songs.size()-1){
            playList.add(this.songs.get(index));
            return true;
        }

        return false;
    }
}
