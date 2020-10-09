package pojos;

public class clearCartPojo {
	private String cart_key;
	private int portal_id;
	private String cart_type;
	public clearCartPojo(String cart_key, int portal_id, String cart_type) {
		this.cart_key = cart_key;
		this.portal_id = portal_id;
		this.cart_type = cart_type;
	}
	public String getCart_key() {
		return cart_key;
	}
	public void setCart_key(String cart_key) {
		this.cart_key = cart_key;
	}
	public int getPortal_id() {
		return portal_id;
	}
	public void setPortal_id(int portal_id) {
		this.portal_id = portal_id;
	}
	public String getCart_type() {
		return cart_type;
	}
	public void setCart_type(String cart_type) {
		this.cart_type = cart_type;
	}
	@Override
	public String toString() {
		return "clearCartPojo [cart_key=" + this.cart_key + ", portal_id=" + this.portal_id + ", cart_type=" + this.cart_type + "]";
	}

}
