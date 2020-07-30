package myusb;

public class Main {

    public static void main(String[] args) {
        // 首先创建一个笔记本电脑
        Laptop laptop = new Laptop();
        laptop.powerOpen();

        // 创建一个鼠标以使用
        // Mouse mouse = new Mouse();
        // 首先进行向上转型
        // USB usb = mouse;
        USB usbMouse = new Mouse(); // 多态写法
        // 参数是USB类型，传递进去的是USB鼠标
        laptop.useDevice(usbMouse);

        // 创建一个USB键盘
        Keybord keybord = new Keybord(); // 没有使用多态写法
        // 方法参数是USB类型，传递进去的是实现类对象
        laptop.useDevice(keybord); // 向上转型
        // 使用子类匿名对象
        // laptop.useDevice(new Keybord());

        laptop.powerOff();
    }
}
