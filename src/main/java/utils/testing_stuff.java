//package utils;
//
//import entities.Ingredient;
//import entities.Recipe;
//import entities.RecipeIngredient;
//import entities.User;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//public class testing_stuff {
//
//    public static void main(String[] args) {
//        testingAllRelations();
//
//
//    }
//
////test if the recipe is added to the user and the user is added to the recipe
//    public static void test() {
//        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//        //user
//        User u = em.find(User.class, "user");
//        Recipe r = new Recipe("relationTest","relationTest","relationTest",u);
//
//
//        em.getTransaction().begin();
//        em.persist(r);
//        em.getTransaction().commit();
//    }
//
//
//    public static void test2() {
//        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//        //user
//        User u = em.find(User.class, "user");
//        u.getRecipes().forEach(r -> System.out.println(r.getTitle()));
//    }
//
//
//    public static void test3() {
//        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//        //user
//        User u = em.find(User.class, "user");
//
//        //recipe
//        Recipe r = new Recipe("relationTest","relationTest","relationTest",u);
//
//        //recipe ingredients
//        RecipeIngredient ri1 = new RecipeIngredient("relationTest1", "relationTest1", "relationTest1");
//        RecipeIngredient ri2 = new RecipeIngredient("relationTest2", "relationTest2", "relationTest2" );
//
//        //ingredients for recipe
//        Ingredient i1 = em.find(Ingredient.class, 3L);
//        Ingredient i2 = em.find(Ingredient.class, 4L);
//
//
//        //add ingredients to recipe
//        ri1.addIngredient(i1);
//        ri2.addIngredient(i2);
//        //add recipe ingredients to recipe
//        ri1.addRecipe(r);
//        ri2.addRecipe(r);
//
//        em.getTransaction().begin();
//        em.persist(r);
//        em.persist(ri1);
//        em.persist(ri2);
//        em.getTransaction().commit();
//    }
//    public static void test4() {
//        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//        //user
//        User u = em.find(User.class, "user");
//
//        //recipe
//        Recipe r = new Recipe("relationTest","relationTest","relationTest",u);
//
//        //recipe ingredients
//        RecipeIngredient ri1 = new RecipeIngredient("relationTest1", "relationTest1", "relationTest1");
//        RecipeIngredient ri2 = new RecipeIngredient("relationTest2", "relationTest2", "relationTest2");
//
//        //ingredients for recipe
//        Ingredient i1 = em.find(Ingredient.class, 3L);
//        Ingredient i2 = em.find(Ingredient.class, 4L);
//
//
//        //add ingredients to recipe
//        ri1.addIngredient(i1);
//        ri2.addIngredient(i2);
//        //add recipe ingredients to recipe
//        ri1.addRecipe(r);
//        ri2.addRecipe(r);
//
//        em.getTransaction().begin();
//        em.persist(r);
//        em.getTransaction().commit();
//    }
//
//    public static void testingAllRelations() {
//        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//
//        Recipe r = em.find(Recipe.class, 16L);
//        RecipeIngredient ri25 = em.find(RecipeIngredient.class, 25L);
//        System.out.println("users name for recipeId 16: " + r.getUser().getUserName());
//        System.out.println("Recipe ingredients for recipe(16):");
//        r.getRecipeIngredients().forEach(ri -> System.out.println(ri.getId() + " " + ri.getName() + " " + ri.getAmount() + " " + ri.getUnit()));
//
//        System.out.println("Recipe for recipeIngredient(11): " + ri25.getRecipe().getTitle() + " " + ri25.getRecipe().getDescription() + " " + ri25.getRecipe().getInstructions() + " " + ri25.getRecipe().getId() + " " + ri25.getRecipe().getRecipeIngredients().get(0).getIngredient().getId() + " " + ri25.getRecipe().getRecipeIngredients().get(0).getIngredient().getName());
//    }
//
//
//
//}
