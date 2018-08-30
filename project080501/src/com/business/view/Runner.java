package com.business.view;

import org.junit.Test;

public class Runner {
	private AdminProcess ap;
	private ProductsProcess pdp;
	private ProviderProcess pvp;
	private CategoryProcess cp;
	public Runner(){
		ap = new AdminProcess();
		pdp = new ProductsProcess();
		pvp = new ProviderProcess();
		cp = new CategoryProcess();
	}
	@Test
	public void RunnerProcess(){
		while(true){
			System.out.println("1:对Admin表的操作    2：对Products表的操作      3：对Providers表的操作    4：对Categorys表的操作     5：退出");
			String op = Process.input();
			if("1".equals(op)){
				ap.process();
			}else if("2".equals(op)){
				pdp.process();
			}else if("3".equals(op)){
				pvp.process();
			}else if("4".equals(op)){
				cp.process();
			}else if("5".equals(op)){
				break;
			}
		}
		
	}
}
