package SQL;

import DatabaseOperations.DB;
import Klassen.Address;

import java.sql.SQLException;

public class UpdateStmt {
    public static void updateAddress(Address address){
        String query = "UPDATE address " +
                "SET street = '" + address.getStreet() + "', " +
                "hnr = '" + address.getHnr() + "', " +
                "plz = '" + address.getPlz() + "', " +
                "city = '" + address.getCity() + "', " +
                "country = '" + address.getCountry() +"' " +
                "WHERE addressid = " + address.getId();
        try(
                var conn = DB.userconnect();
                var stmt = conn.createStatement()
        ){
            var resultSet = stmt.executeUpdate(query);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
