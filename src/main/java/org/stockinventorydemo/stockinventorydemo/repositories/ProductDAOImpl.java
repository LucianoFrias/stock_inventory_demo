package org.stockinventorydemo.stockinventorydemo.repositories;

import org.stockinventorydemo.stockinventorydemo.database.Database;
import org.stockinventorydemo.stockinventorydemo.models.Product;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void insert(Product product) {
        String table = "product";

        try (Connection conn = Database.getConnection()) {

            Field[] fields = Product.class.getDeclaredFields();
            List<String> columnNames = new ArrayList<>();
            List<Object> values = new ArrayList<>();

            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers())) continue;

                String name = field.getName();
                if (name.equalsIgnoreCase("id")) continue; // NO insertamos ID

                field.setAccessible(true);
                Object value = field.get(product);

                columnNames.add(name);
                values.add(value);
            }

            String columns = String.join(", ", columnNames);
            String placeholders = String.join(", ", Collections.nCopies(values.size(), "?"));

            String sql = "INSERT INTO " + table + " (" + columns + ") VALUES (" + placeholders + ")";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                for (int i = 0; i < values.size(); i++) {
                    ps.setObject(i + 1, values.get(i));
                }

                ps.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        String table = "product";

        try (Connection conn = Database.getConnection()) {

            Field[] fields = Product.class.getDeclaredFields();
            List<String> assigns = new ArrayList<>();
            List<Object> values = new ArrayList<>();
            Object idValue = null;

            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers())) continue;

                field.setAccessible(true);
                Object value = field.get(product);
                String name = field.getName();

                if (name.equalsIgnoreCase("id")) {
                    idValue = value;   // lo guardamos para el WHERE
                } else {
                    assigns.add(name + "=?");
                    values.add(value);
                }
            }

            String sql = "UPDATE " + table + " SET " +
                    String.join(", ", assigns) +
                    " WHERE id=?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                for (int i = 0; i < values.size(); i++) {
                    ps.setObject(i + 1, values.get(i));
                }

                ps.setObject(values.size() + 1, idValue);

                ps.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM product WHERE id=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Product> findById(int id) {
        String sql = "SELECT * FROM product WHERE id=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Product product = new Product();
                ResultSetMetaData meta = rs.getMetaData();
                int columnCount = meta.getColumnCount();

                for (int i = 1; i <= columnCount; i++) {

                    String columnName = meta.getColumnName(i);

                    try {
                        Field field = Product.class.getDeclaredField(columnName);
                        field.setAccessible(true);

                        Object value = rs.getObject(columnName);

                        field.set(product, value);

                    } catch (NoSuchFieldException ignored) {
                        // Si la columna existe en DB pero no en Product, la ignoramos
                    }
                }

                return Optional.of(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM product";

        try (Connection conn = Database.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();


            while (rs.next()) {
                Product product = new Product();

                for (int i = 1; i <= columnCount; i++){
                    String columnName = meta.getColumnName(i);

                    try {
                        Field field = Product.class.getDeclaredField(columnName);
                        field.setAccessible(true);

                        Object value = rs.getObject(columnName);
                        field.set(product, value);
                    } catch (NoSuchFieldException ignored) {

                    }
                }
                list.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
