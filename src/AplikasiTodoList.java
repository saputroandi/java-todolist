public class AplikasiTodoList {

    public static String[] models = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     *  menampilkan todo list
     */
    public static void showTodoList(){
        System.out.println("TODOLIST");

        for(var i = 0; i < models.length; i++){
            var task = models[i];
            var no = i + 1;

            if(task != null) System.out.println(no + ". " + task);
        }

    }

    /**
     *  menambah todo list
     */
    public static void addTodoList(String task){

        var isFull = true;

        for(var i = 0; i < models.length; i++){
            if(models[i] == null){
                isFull = false;
                break;
            }
        }

        if(isFull){
            var temp = models;

            models = new String[models.length * 2];

            for(var i = 0; i < temp.length; i++){
                models[i] = temp[i];
            }
        }

        for(var i = 0; i < models.length; i++){
            if(models[i] == null){
                models[i] = task;
                break;
            }
        }

    }

    /**
     *  menghapus todo list
     */
    public static boolean removeTodoList(Integer number){
        var idx = number - 1;

        if(idx >= models.length ) return false;
        if(models[idx] == null) return false;

         for (var i = idx; i < models.length; i++){
             models[i] = (i != (models.length - 1)) ? models[i + 1] : null ;
         }
         return true;
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    /**
     *  menampilkan todo list
     */
    public static void viewShowTodoList(){
        while(true){
            showTodoList();

            System.out.println("Menu:");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if(input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("x")){
                break;
            }else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    /**
     *  menampilkan tambah todo list
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAHKAN TODOLIST");

        var todo = input("Todo (x) jika batal");

        if (todo.equals("x")){
            // batal
        }else{
            addTodoList(todo);
        }
    }

    /**
     *  menampilkan hapus todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (x) jika batal");

        if (number.equals("x")){
            // batal
        } else {
            var success = removeTodoList(Integer.valueOf(number));

            if(!success){
                System.out.println("Gagal menghapus todolist: " + number);
            }
        }
    }

}






