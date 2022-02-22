package tests;

import dissertation.AddDishController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import server_side.Database;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class Reload {
  AddDishController ad;
  Database          db;

  @Test
  void reset() {
    db = new Database();
    if (db.getConnection() != null) {
      db.closeDatabase();
    }
    db.openDatabase();
    db.resetDatabase("tabledef", "blankdata");
    db.closeDatabase();
  }
}