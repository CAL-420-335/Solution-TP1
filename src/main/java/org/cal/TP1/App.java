package org.cal.TP1;

import org.cal.TP1.cli.CliApp;
import org.cal.TP1.db.Db;
import org.cal.TP1.db.DbController;
import org.cal.TP1.db.IDbController;

public class App
{
    public static void main( String[] args )
    {
        IDbController dbController = new DbController();

        CliApp cli = new CliApp(dbController);
        cli.start();
    }
}
