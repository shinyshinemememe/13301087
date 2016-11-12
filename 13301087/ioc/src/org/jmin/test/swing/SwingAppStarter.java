package org.jmin.test.swing;

import org.jmin.app.gui.security.LoginContext;
import org.jmin.app.gui.security.SecurityContext;
import org.jmin.app.gui.security.SecurityLauncher;

/***
 * 启动工作台
 */
public class SwingAppStarter extends SecurityLauncher {

  /**
   * 安全登陆Context
   */
  public SecurityContext getSecurityContext() {
    return new LoginContext();
  }

  /**
   * 测试方法
   */
  public static void main(String[] args)throws Exception {
    SwingAppStarter launcher = new SwingAppStarter();
    launcher.launch("org/jmin/test/swing/swing.xml");
  }
}