public class Repo {
    public static boolean createRepo(Tree<String> folder, String repo) throws Exception{

        if (folder.data().compareTo(repo) == 0){
            folder.addChildren(new Tree<>(".git"));
            return true;
        }else{
            boolean hasBeenCreated = false;
            for(int i = 0; i < folder.nbChildren() && !hasBeenCreated; i++){
                hasBeenCreated = createRepo(folder.child(i), repo);
            }
            return hasBeenCreated;
        }
    }

    public static void main(String...args){
        Tree<String> folder = new Tree<>("app",
                                    new Tree<>("bin"),
                                    new Tree<>("src",
                                        new Tree<>("assets"),
                                        new Tree<>("front"),
                                        new Tree<>("back")
                                    ),
                                    new Tree<>("project", 
                                        new Tree<>("keys",
                                            new Tree<>("api")
                                        )
                                    )
        );

        try {
            folder.display();
            createRepo(folder, "project");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            folder.display();
            createRepo(folder, "api");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            folder.display();
            createRepo(folder, "doesNotExist");
        } catch (Exception e) {
            System.out.println(e);
        }

        folder.display();
    }
}
