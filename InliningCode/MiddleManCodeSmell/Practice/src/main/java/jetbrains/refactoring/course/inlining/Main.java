package jetbrains.refactoring.course.inlining;

public class Main {
   public static void main(String[] args) {
      Client client = new Client();
      System.out.println(client.processData()); // Output: Data from the server
   }
}

// DataProvider class
class DataProvider {
   String fetchData() {
      // Some complex logic to fetch data from a remote server
      return "Data from the server";
   }
}

// Client class using MiddleMan
class Client {
   String processData() {
      DataProvider dataProvider = new DataProvider();
      return dataProvider.fetchData();
   }
}
