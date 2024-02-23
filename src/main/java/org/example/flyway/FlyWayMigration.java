package org.example.flyway;

import org.example.db.DbConfig;
import org.flywaydb.core.Flyway;

public class FlyWayMigration {
    public static void migrate(){
        DbConfig dbConfig = new DbConfig();
        
        Flyway flyway = Flyway
                .configure()
                .dataSource(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword())
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();
    }
}
