public class Animal {
    String name;
    String favoriteActivity;
    String favoriteFood;
    String environment;

    public Animal(){

    }

    public Animal(String name, String favoriteActivity, String favoriteFood , String environment) {
        this.name=name;
        this.favoriteActivity=favoriteActivity;
        this.favoriteFood=favoriteFood;
        this.environment=environment;
    }

    public void setName(String newName) {

        this.name=newName;
    }
    public String getName() {

        return name;
    }
    public void setFavoriteActivity(String newFavoriteActivity) {

        this.favoriteActivity=newFavoriteActivity;
    }
    public String getFavoriteActivity() {

        return favoriteActivity;
    }
    public void setFavoriteFood(String newFavoriteFood) {

        this.favoriteFood=newFavoriteFood;
    }
    public String getFavoriteFood() {

        return favoriteFood;
    }

}