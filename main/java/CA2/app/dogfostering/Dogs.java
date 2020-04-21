package CA2.app.dogfostering;


public class Dogs {

    private String id  ;
    private String name;
    private String breed;
    private double age;
    private String information;
    private String imageURL;
    private boolean isAdopted;


    public Dogs(String id, String name, String breed, double age, String information, String imageURL, boolean isAdopted) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.information = information;
        this.imageURL = imageURL;
        this.isAdopted = isAdopted;
    }

    public Dogs(String id, String name, String breed, double age, String information, String imageURL) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.information = information;
        this.imageURL = imageURL;

    }

    public Dogs(boolean isAdopted) {
        this.isAdopted = isAdopted;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public double getAge() {
        return age;
    }

    public String getInformation() {
        return information;
    }

    public String getImageURL() {
        return imageURL;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", breed='" + breed + '\'' +
                        ", age=" + age +
                        ", information='" + information + '\'' +
                        ", imageURL='" + imageURL + '\'' +
                        ", isAdopted=" + isAdopted +
                        '}';
    }
}
