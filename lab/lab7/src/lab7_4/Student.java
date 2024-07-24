package lab7_4;

public class Student {

    private String name;
    private String address;

    public void setName(String name) throws IllegaNameException {
        if(name.length() < 1 || name.length() >=5 ){
            throw new IllegaNameException();
        }
        this.name = name;
    }

    public void setAddress(String address) throws IllegalAddressException{
        boolean flag = false;
        for(int i = 0; i < address.length(); i++){
            if(address.charAt(i) == '省'){
                for(int j = i; j < address.length(); j++){
                    if(address.charAt(j) == '市'){
                        flag = true;
                        break;
                    }
                }
            }
        }
        if(flag) {
            this.address = address;
        } else {
            throw new IllegalAddressException();
        }
    }

    public static void main(String[] args) throws IllegaNameException, IllegalAddressException {
        // Java不允许在一个catch块中同时抛出两个异常。同时，Java也不允许在一个catch块中捕获多个异常然后再抛出。你需要将它们分开处理。
        IllegaNameException nameException = null;
        IllegalAddressException addressException = null;

        try {
            new Student().setName("");
        } catch (IllegaNameException e) {
            System.out.println(e);
            e.printStackTrace();
            nameException = e;
        }

        try {
            new Student().setAddress("");
        } catch (IllegalAddressException e) {
            System.out.println(e);
            e.printStackTrace();
            addressException = e;
        }

        if (nameException != null) {
            throw nameException;
        }

        if (addressException != null) {
            throw addressException;
        }
    }
}
