package JDBC;
import java.sql.*;
import java.util.ArrayList;
import com.mysql.cj.jdbc.Driver;

public class JDBCDemo {

    private static ArrayList<Album> albums = new ArrayList<>();
    static Config config = new Config();

    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection (
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM albums");

            //Transforming the ResultSet into a Java Collection
            while (rs.next()) {
                albums.add(new Album (
                        rs.getLong("id"),
                        rs.getString("artist"),
                        rs.getString("name"),
                        rs.getInt("release_date"),
                        rs.getFloat("sales"),
                        rs.getString("genre")
                ));
            }
            printAlbums(albums);

//            statement.executeUpdate("INSERT INTO albums (artist, name, release_date, genre, sales) VALUES('Nelly Furtado', 'Loose', 2006, 'Dance-pop, hip hop, R&B', 12.5)");
            rs = statement.executeQuery("SELECT * FROM albums");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void printAlbums(ArrayList<Album> albums) {
        for (Album album: albums) {
            System.out.println(album.getArtist());
        }
    }


}
