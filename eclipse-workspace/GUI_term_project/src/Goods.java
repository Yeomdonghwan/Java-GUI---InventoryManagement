import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

class UserComparator implements Comparator<Goods>{
	@Override
	public int compare(Goods g1, Goods g2) {
		// 단어 길이가 같을 경우
		if(g1.getId().length() == g2.getId().length()) {
			return g1.getId().compareTo(g2.getId());	// 사전 순 정렬
		}
		// 그 외의 경우
		else {
			return g1.getId().length() - g2.getId().length();
		}}
}

public class Goods {
	private String id;
	private String name;
	private int price;
	private int stock=0;
	private String date;
	
	public Goods(String id, String name, int price) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.setDate();
	}
	@Override
	public boolean equals(Object obj) {
		return ((Goods) obj).getId().equals(this.getId());
	}
	private int compareTo(Object o) {
		Goods e = (Goods) o;
        return getId().compareTo(e.getId());

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDate() {
		return date;
	}
	public void setDate() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = now.format(formatter);
		this.date=formatedNow;
	}
}
