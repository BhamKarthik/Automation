package pojos;

public class getCartPojo {


	private String cart_key;
	private int portal_id;
	private String cart_type;
	private int pin_code;
	
	public getCartPojo(String cart_key, int portal_id, String cart_type, int pin_code) {
		this.cart_key = cart_key;
		this.portal_id = portal_id;
		this.cart_type = cart_type;
		this.pin_code = pin_code;
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
	public int getPin_code() {
		return pin_code;
	}
	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}
	@Override
	public String toString() {
		return "CartApiPojo [cart_key=" + this.cart_key + ", portal_id=" + this.portal_id + ", cart_type=" + this.cart_type
				+ ", pin_code=" + this.pin_code + "]";
	}
	
}