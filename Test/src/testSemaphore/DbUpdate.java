package testSemaphore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DbUpdate {

    DbConnection con = new DbConnection();
    Statement st;

    DbUpdate() throws SQLException {
        st = con.connection().createStatement();
    }

    public void recordInDb(int id, int mark) throws SQLException {
        if (checkRecord(id)) {
            //System.out.println("Record exists");
            int res = st.executeUpdate("UPDATE examresults SET mark =" + mark 
                    + " WHERE id = " + id);
        } else {
            int res = st.executeUpdate("INSERT INTO examresults "
                    + "VALUES (" + id + "," + mark + ")");
        }
    }

    public boolean checkRecord(int id) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT id, mark from examresults "
                + "WHERE id = " + id);

        int result = 0;
        while (rs.next()) {
            result = rs.getInt(1);
        }

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

}
