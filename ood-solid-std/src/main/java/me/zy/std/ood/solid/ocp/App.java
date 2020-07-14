package me.zy.std.ood.solid.ocp;

/**
 * @author zhaoyang on 2020-06-22.
 */
public class App {

    public static void main(String[] args) {
        // build WinForm
        WinForm winForm = new WinForm("WINDOW窗口");
        winForm
            .addSubComponent(new Picture("LOGO图片")) // build Picture
            .addSubComponent(new Button("登录"))      // build Login Button
            .addSubComponent(new Button("注册"));     // build Register Button
        // build Frame
        Frame frame = new Frame("FRAME1");
        winForm.addSubComponent(frame);
        frame
            .addSubComponent(new Label("用户名"))           // build username Label
            .addSubComponent(new TextBox("用户名文本框"))    // build username TextBox
            .addSubComponent(new Label("密码"))             // build password Label
            .addSubComponent(new PasswordBox("密码框"))     // build PasswordBox
            .addSubComponent(new CheckBox("复选框"))        // build CheckBox
            .addSubComponent(new TextBox("记住用户名"))      // build remember username CheckBox
            .addSubComponent(new LinkLabel("忘记密码"));     // build forget password LinkLabel
        // display window
        winForm.display();
    }
}
