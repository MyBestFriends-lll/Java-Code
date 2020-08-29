package Database.dataSource.JdbcTemplate;

public class Account {
	// 注意：基本数据类型不能接收null，应该使用引用数据类型
	private Integer id;
	private String name;
	private Double money;

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", name='" + name + '\'' +
				", money=" + money +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
}
