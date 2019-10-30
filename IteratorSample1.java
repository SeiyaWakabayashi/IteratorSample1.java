public class IteratorSample1 {
     public static void main(String[] args) {
	     GameListAggregate gameListAggregate = new GameListAggregate();
	     Iterator iterator = gameListAggregate.createIterator();
	     Game game =new Game[10];
         game[0] =new Game(name'AAA',price:1000);
         game[1] =new Game(name 'BBB',price:1980);

         List<Game>gameList = new ArryList<Game>();
         gameList.add(new Game(name:"CCC",price:2980));
         gameList.add(new Game(name:"DDD",price:1100));

        iterator.first(); // まず探す場所を先頭位置にしてもらう
         while ( ! iterator.isDone() ) { // まだある？ まだあるよ！
             Game game = (Game)iterator.getItem(); // はいどうぞ (と受取る)
             System. out .println(game.getName());
             iterator.next(); // 次を頂戴




         }
     }
 }

 interface Iterator {
     public void first();
     public void next();
     public boolean isDone();
     public Object getItem();
 }

class GameListIterator implements Iterator {
     private GameListAggregate aggregate;
     private int current;
     public GameListIterator(GameListAggregate aggregate) {
         this.aggregate = aggregate;
     }

    @Override
     public void first() {
         current = 0;
    }

    @Override
     public void next() {
         current += 1;
     }

    @Override
     public boolean isDone() {
         if (current >= aggregate.getNumberOfStock()) {
             return true;
         }
         else {
             return false;
         }
     }

    @Override
     public Object getItem() {
        return aggregate.getAt(current);
     }



 interface Aggregate {
     public Iterator createIterator();
 }

 class GameListAggregate implements Aggregate {
     private Game[] list = new Game[20];
     private int numberOfStock;
     List<Game> list = new ArrayLIst<>();

    @Override
     public Iterator createIterator() {
         return new GameListIterator(this);
     }

    public void add(Game game) {
         list[numberOfStock] = game;
         numberOfStock += 1;
     }

    public Object getAt(int number) {
         return list[number];
         return list.get(number);
    }

    public int getNumberOfStock() {
         return numberOfStock;
         return list.size();
     }
 }


// ゲームソフト
class Game {
     private String name;  // 名称
	 private  int price;  // 価格

    public Game(String name, int price) { // コンストラクタ
	         this.name= name;
			 this.price = price;
    }

    public String getName() { // 名称を取得
	         return name;
	}

    public int getPrice() { // 価格を取得
	         return price;
	}
}



