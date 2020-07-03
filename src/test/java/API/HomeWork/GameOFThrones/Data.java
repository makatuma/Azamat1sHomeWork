package API.HomeWork.GameOFThrones;

import java.util.List;

public  class Data {

   private List<String> titles;
   private List<String> books;
   private String _id;
   private boolean male;
   private String house;
   private String slug;
   private String name;
   private String createdAt;
   private String updatedAt;
   private int __v;
   private int dateOfDeath;
   private int dateOfBirth;
   private String  imageLink;
   private String culture;
   private String father;
   private String mother;
   private String heir;
   private String spouse;
   private boolean hasPath;

   public boolean isHasPath() {
      return hasPath;
   }

   public void setHasPath(boolean hasPath) {
      this.hasPath = hasPath;
   }

   public String getSpouse() {
      return spouse;
   }

   public void setSpouse(String spouse) {
      this.spouse = spouse;
   }

   public String getHeir() {
      return heir;
   }

   public void setHeir(String heir) {
      this.heir = heir;
   }

   public String getCulture() {
      return culture;
   }

   public void setCulture(String culture) {
      this.culture = culture;
   }

   public String getFather() {
      return father;
   }

   public void setFather(String father) {
      this.father = father;
   }

   public String getMother() {
      return mother;
   }

   public void setMother(String mother) {
      this.mother = mother;
   }

   public String getImageLink() {
      return imageLink;
   }

   public void setImageLink(String imageLink) {
      this.imageLink = imageLink;
   }

   public int getDateOfDeath() {
      return dateOfDeath;
   }

   public void setDateOfDeath(int dateOfDeath) {
      this.dateOfDeath = dateOfDeath;
   }

   public int getDateOfBirth() {
      return dateOfBirth;
   }

   public void setDateOfBirth(int dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   ;


   public List<String> getTitles() {
      return titles;
   }

   public void setTitles(List<String> titles) {
      this.titles = titles;
   }

   public List<String> getBooks() {
      return books;
   }

   public void setBooks(List<String> books) {
      this.books = books;
   }

   public String get_id() {
      return _id;
   }

   public void set_id(String _id) {
      this._id = _id;
   }

   public boolean isMale() {
      return male;
   }

   public void setMale(boolean male) {
      this.male = male;
   }

   public String getHouse() {
      return house;
   }

   public void setHouse(String house) {
      this.house = house;
   }

   public String getSlug() {
      return slug;
   }

   public void setSlug(String slug) {
      this.slug = slug;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(String createdAt) {
      this.createdAt = createdAt;
   }

   public String getUpdatedAt() {
      return updatedAt;
   }

   public void setUpdatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
   }

   public int get__v() {
      return __v;
   }

   public void set__v(int __v) {
      this.__v = __v;
   }
}
