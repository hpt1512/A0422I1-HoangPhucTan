package repository;

import model.ClassCG;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository implements IClassRepository {
    @Override
    public List<ClassCG> findAll() {
        List<ClassCG> classCGList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from class;");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                ClassCG classCG = new ClassCG(id,name);
                classCGList.add(classCG);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classCGList;
    }
}
