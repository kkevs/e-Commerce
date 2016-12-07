package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UserDaoImpl;
import model.User;

@ManagedBean
@SessionScoped
public class UserBean {
	User user = new User();
	UserDaoImpl daoImlp = new UserDaoImpl();

	boolean b;

	public UserBean() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDaoImpl getDaoImlp() {
		return daoImlp;
	}

	public void setDaoImlp(UserDaoImpl daoImlp) {
		this.daoImlp = daoImlp;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public void saveUser() {
		daoImlp.saveUser(user);
	}

	public String controlUser() {
		int i = daoImlp.controlUser(user);
		if (i == 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Failure Message", "Login Failure"));
			b = false;
			return "login?faces-redirect=true";

		}
		if (i == 1) {
			b = true;
			return "admin?faces-redirect=true";

		}
		if (i == 2) {
			b = true;
			return "index?faces-redirect=true";
		}
		b = false;
		return "error?faces-redirect=true";
	}

	 public String logout() {
	 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	 return "/index.xhtml?faces-redirect=true";
	 }

}
