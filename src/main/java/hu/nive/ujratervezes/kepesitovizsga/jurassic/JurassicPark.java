package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JurassicPark {


    private DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        List<String> result = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("select breed from dinosaur where actual > expected");
        ) {
            try (ResultSet rs = ps.executeQuery()) {
                String dino = "";
                while (rs.next()) {
                    dino = rs.getString("breed");
                    result.add(dino);
                }
                Collections.sort(result);
                return result;
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select songs", se);
        }
    }
}
