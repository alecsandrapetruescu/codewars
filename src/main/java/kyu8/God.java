package kyu8;

public class God {
    public static Human[] create(){
        Human[] create = new Human[2];
        create[0] = new Man();
        create[1] = new Woman();
        return create;
    }
}

interface Human {
}

class Man implements Human {
}

class Woman implements Human {
}