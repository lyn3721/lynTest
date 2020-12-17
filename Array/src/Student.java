public class Student {

    private String name;
    private int score;

    public Student(String Studentname, int Socre){
        name = Studentname;
        score = Socre;
    }

    @Override
    public String toString() {
        return String.format("学生（姓名 :%s, 分数：%d",name,score);

    }

    public static void main(String[] args) {
        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("小明",100));
        studentArray.addLast(new Student("小红",100));
        studentArray.addLast(new Student("小刚",100));
        System.out.println(studentArray);

    }
}
