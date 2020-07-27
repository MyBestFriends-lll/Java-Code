package myusb;
/*
使用usb接口
 */
public class Laptop {
    public void powerOpen() {
        System.out.println("笔记本电脑开机");
    }
    public void powerOff() {
        System.out.println("笔记本电脑关机");
    }

    // 使用USB设备的方法，使用接口作为方法的参数
    public void useDevice(USB usb) {
        usb.open(); // 打开设备

        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb; // 向下转型
            mouse.click();
        } else if (usb instanceof Keybord) {
            Keybord keybord = (Keybord) usb;
            keybord.type();
        }
        usb.close(); // 关闭设备
    }
}
