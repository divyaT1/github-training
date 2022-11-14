package com.KrystalMovies.FoodMobsAPI.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.KrystalMovies.FoodMobsAPI.Model.CartList;
import com.KrystalMovies.FoodMobsAPI.Model.CartListPk;
import com.KrystalMovies.FoodMobsAPI.Model.Cartids;
import com.KrystalMovies.FoodMobsAPI.Model.Dishid;
import com.KrystalMovies.FoodMobsAPI.Model.Orderid;
import com.KrystalMovies.FoodMobsAPI.Model.OrderidPk;
import com.KrystalMovies.FoodMobsAPI.Model.Orderids;
import com.KrystalMovies.FoodMobsAPI.Repository.CartListRepository;
import com.KrystalMovies.FoodMobsAPI.Repository.CartidsRepository;
import com.KrystalMovies.FoodMobsAPI.Repository.OrderidRepository;
import com.KrystalMovies.FoodMobsAPI.Repository.OrderidsRepository;
import com.KrystalMovies.FoodMobsAPI.Service.OrdersService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	CartListRepository cartListRepository;
	
	@Autowired
	OrderidRepository orderidRepository;
	
	@Autowired
	OrderidsRepository orderidsRepository;
	
	@Autowired
	CartidsRepository cartidsRepository;

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map generateCart(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			CartListPk cartListPk = new CartListPk();
			CartList cartList = new CartList();
			
			List idlist = getCARTidgenrated();
			String cartid = ((Map) idlist.get(0)).get("id").toString();
			
			cartListPk.setCartid(cartid);
			cartListPk.setDishid(jsonbody.get("dishid").toString());
			
			cartList.setQuantity(Integer.valueOf(jsonbody.get("qnty").toString()));
			cartList.setAddedOn(new Date());
			
			cartList.setCartListPk(cartListPk);
			
			cartList.setCartstatus(jsonbody.get("cartstatus").toString());
			cartList.setRate(Integer.valueOf(jsonbody.get("rate").toString()));
			cartList.setDishname(jsonbody.get("dishname").toString());
			int fullrate = Integer.valueOf(jsonbody.get("fullrate").toString());
			cartList.setFullrate(fullrate);
			int halfrate = Integer.valueOf(jsonbody.get("halfrate").toString());
			cartList.setHalfrate(halfrate);
			cartList.setImagename(jsonbody.get("imagename").toString());
			cartList.setModifiedOn(new Date());
			cartList.setSubtotal(Integer.valueOf(jsonbody.get("subtotal").toString()));
			cartList.setUserid(jsonbody.get("userid").toString());
			
			cartListRepository.save(cartList);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Transactional
	@Override
	public Map generateOrder(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			List orderlist = (List) jsonbody.get("orderlist");
			List<Map> listorder = new ArrayList<Map>();
			
			List idlist = getvendoridgenrated();
			String Orid = ((Map) idlist.get(0)).get("id").toString();
			
			for (int i = 0; i < orderlist.size(); i++) {
				Map map1 = new HashMap();
				map1 = (Map) orderlist.get(i);
				
				OrderidPk orderidPk = new OrderidPk();
				Orderid orderid = new Orderid();
				
				if (map1.get("cartstatus").toString().equals("Y")) {
					
					orderidPk.setOrderid(Orid);
					orderidPk.setDishid(map1.get("dishid").toString());

					orderid.setActivestatus(map1.get("cartstatus").toString());
					orderid.setAddedOn(new Date());
					orderid.setCustomername(jsonbody.get("customername").toString());
					orderid.setCustomernumber(jsonbody.get("contact").toString());
					orderid.setDishname(map1.get("dishname").toString());
					orderid.setImagename(map1.get("imagename").toString());
					orderid.setModifiedOn(new Date());

					orderid.setOrderidPk(orderidPk);
					orderid.setOrderstatus("P");
					orderid.setQuantity(Integer.valueOf(map1.get("qnty").toString()));
					orderid.setRate(Integer.valueOf(map1.get("rate").toString()));
					orderid.setSubtotal(Integer.valueOf(map1.get("subtotal").toString()));
					orderid.setTotal(Integer.valueOf(jsonbody.get("total").toString()));
					orderid.setUserid(jsonbody.get("userid").toString());
					orderid.setOrderfrom("O");

					String dishid = map1.get("dishid").toString();
					String userid = jsonbody.get("userid").toString();

					String scount = orderidRepository.getsalecount(dishid, userid);

					int salecount = 1;
					salecount = salecount + Integer.valueOf(scount);

					orderidRepository.updatedishsales(dishid, userid, salecount);

					orderidRepository.save(orderid);
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Transactional
	@Override
	public Map wgenerateOrder(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			List orderlist = (List) jsonbody.get("orderlist");
			
			List idlist = getvendoridgenrated();
			String Orid = ((Map) idlist.get(0)).get("id").toString();
			
			String cartid = "";
			String userid = jsonbody.get("userid").toString();
			
			for (int i = 0; i < orderlist.size(); i++) {
				Map map1 = new HashMap();
				map1 = (Map) orderlist.get(i);
				
				if (map1.get("cartstatus").toString().equals("Y")) {

					OrderidPk orderidPk = new OrderidPk();
					Orderid orderid = new Orderid();

					orderidPk.setOrderid(Orid);
					orderidPk.setDishid(map1.get("dishid").toString());

					orderid.setActivestatus(map1.get("cartstatus").toString());
					orderid.setAddedOn(new Date());
					orderid.setCustomername(jsonbody.get("customername").toString());
					orderid.setCustomernumber(jsonbody.get("contact").toString());
					orderid.setDishname(map1.get("dishname").toString());
					orderid.setImagename(map1.get("imagename").toString());
					orderid.setModifiedOn(new Date());

					orderid.setOrderidPk(orderidPk);
					orderid.setOrderstatus("P");
					orderid.setQuantity(Integer.valueOf(map1.get("quantity").toString()));
					orderid.setRate(Integer.valueOf(map1.get("rate").toString()));
					orderid.setSubtotal(Integer.valueOf(map1.get("subtotal").toString()));
					orderid.setTotal(Integer.valueOf(jsonbody.get("total").toString()));
					orderid.setUserid(jsonbody.get("userid").toString());
					orderid.setOrderfrom("W");

//					cartid = map1.get("cartid").toString();
//
//					orderidRepository.updatecart(cartid, userid);

					orderidRepository.save(orderid);
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}
	
	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Transactional
	@Override
	public Map updateOrder(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String ordid = jsonbody.get("").toString();
			String dishid = jsonbody.get("").toString();
			String activestatus = jsonbody.get("").toString();
			String dishname = jsonbody.get("").toString();
			String userid = jsonbody.get("").toString();
			String imagename = jsonbody.get("").toString();
			String orderstatus = jsonbody.get("").toString();
			String customername = jsonbody.get("").toString();
			String customernumber = jsonbody.get("").toString();
			int quantity = Integer.valueOf(jsonbody.get("").toString()) ;
			int subtotal = Integer.valueOf(jsonbody.get("").toString()) ;
			int total = Integer.valueOf(jsonbody.get("").toString()) ;
			int rate = Integer.valueOf(jsonbody.get("").toString()) ;
			Date modifiedon = new Date();
			
			orderidRepository.updateoderlist(ordid, dishid, activestatus, dishname, userid, imagename, orderstatus,
					customername, customernumber, quantity, subtotal, total, rate, modifiedon);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map getOrders(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String userid = jsonbody.get("userid").toString();
			List<Map> orderList = new ArrayList<Map>();
			List<Map> order = new ArrayList<Map>();
			order = orderidRepository.getOrders(userid);
			for(int i = 0; i < order.size(); i++) {
				Map map1 = new HashMap();
				map1 = order.get(i);
				
				String addedOn1 = new SimpleDateFormat("dd/MM/yyyy").format(map1.get("addedOn")).toString();
				map1.put("addedOn1", addedOn1);
				
				orderList.add(map1);
			}
			String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//			String todate = new SimpleDateFormat("yyyy/MM/dd").parse(date).toString();
			Date todaysdate = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString());
			
			Date tod = new Date();
			
//			String todayordedrs = orderidRepository.gettodaysorderonly(userid, todaysdate);
			map.put("orderList", orderList);
//			map.put("todayordedrs", todayordedrs);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	

//	generateid
	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	public List getvendoridgenrated() {
		List idlist = new ArrayList();
		Map map = new HashMap();
		try {
			String id = "";
			String idn = "";
			String prefix = "TKN-";
			int idno = 0 ;
			
			List idList = orderidRepository.getlastidno();
			
			if(idList.size() == 0 || idList.get(0) == null)
			{
				idno = 0001;
				id = prefix + "1";				
			} else {
				String idnumber = idList.get(0).toString();
				
				idno = Integer.valueOf(idnumber);
				
				String idnum = "";
				if (idno == 0) {
					idnum = "1";
				} else {
					idno = idno + 1;
					idnum = String.valueOf(idno);
				}
				idn = idnum;
				id = prefix + idnum;
			}
			map.put("id", id);
			
			Orderids dishid = new Orderids();
			
			dishid.setId(idno);
			dishid.setPrefix(prefix);
			
			orderidsRepository.save(dishid);
			
			idlist.add(map);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return idlist;
	}
	
	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Transactional
	@Override
	public Map updateorderstatus(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String userid = jsonbody.get("userid").toString();
			String orderid = jsonbody.get("orderid").toString();
			String orderstatus = jsonbody.get("orderstatus").toString();
			
			orderidRepository.updateorderstatus(userid, orderid, orderstatus);
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}
	
//	generateid
	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	public List getCARTidgenrated() {
		List idlist = new ArrayList();
		Map map = new HashMap();
		try {
			String id = "";
			String idn = "";
			String prefix = "CART-";
			int idno = 0 ;
			
			List idList = cartListRepository.getlastidno();
			
			if(idList.size() == 0 || idList.get(0) == null)
			{
				idno = 0001;
				id = prefix + "1";				
			} else {
				String idnumber = idList.get(0).toString();
				
				idno = Integer.valueOf(idnumber);
				
				String idnum = "";
				if (idno == 0) {
					idnum = "1";
				} else {
					idno = idno + 1;
					idnum = String.valueOf(idno);
				}
				idn = idnum;
				id = prefix + idnum;
			}
			map.put("id", id);
			
			Cartids dishid = new Cartids();
			
			dishid.setId(idno);
			dishid.setPrefix(prefix);
			
			cartidsRepository.save(dishid);
			
			idlist.add(map);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return idlist;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map getcartlist(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String userid = jsonbody.get("userid").toString();
			
			List<Map> cartlist = new ArrayList<Map>();
			cartlist = orderidRepository.getcartlist(userid);
			
			map.put("cartlist", cartlist);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Transactional
	@Override
	public Map removecart(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String userid = jsonbody.get("userid").toString();
			String dishid = jsonbody.get("dishid").toString();
			String cartstatus = jsonbody.get("cartstatus").toString();
			
			orderidRepository.removecart(userid, dishid, cartstatus);
						
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	public static ByteArrayInputStream citiesReport() {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(60);
			table.setWidths(new int[] { 1, 3, 3 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Id", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Population", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

//			for (City city : cities) {
//
//				PdfPCell cell;
//
//				cell = new PdfPCell(new Phrase(city.getId().toString()));
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table.addCell(cell);
//
//				cell = new PdfPCell(new Phrase(city.getName()));
//				cell.setPaddingLeft(5);
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table.addCell(cell);
//
//				cell = new PdfPCell(new Phrase(String.valueOf(city.getPopulation())));
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//				cell.setPaddingRight(5);
//				table.addCell(cell);
//			}

			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);

			document.close();

		} catch (DocumentException ex) {
//			Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	@Override
	public byte[] printslip(HttpServletResponse response1, Map jsonbody) throws Exception {		
		ByteArrayOutputStream bstream = new ByteArrayOutputStream();
		try {
			Document document = new Document(PageSize.A4, (float) -50, (float) -50, 0, 0);
			document.setMargins(0, 0, 30, 30);
			
			BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.EMBEDDED);
			Font font1 = new Font(bf, 12, Font.NORMAL);
			Font font2 = new Font(bf, 16, Font.NORMAL);
			Font font3 = new Font(bf, 16, Font.BOLD);
			Font font4 = new Font(bf, 12, Font.BOLD);
			
			PdfWriter.getInstance(document, bstream);
			document.open();
			
			String userid = jsonbody.get("userid").toString();
			String orderid = jsonbody.get("orderid").toString();			
			
			List<Map> orderdata = orderidRepository.getorderdata(userid, orderid);
			
			String customername = orderdata.get(0).get("customername").toString();
			String customernumber = orderdata.get(0).get("customernumber").toString();
			String date = new SimpleDateFormat().format(orderdata.get(0).get("addedOn"));
			String total = orderdata.get(0).get("total").toString();
			
			PdfPTable table = new PdfPTable(4);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("FoodMobs", font3));
			hcell.setColspan(4);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Name : " + customername, font1));
			hcell.setColspan(2);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(0);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Token No. : " + orderid, font1));
			hcell.setColspan(2);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setBorder(0);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Contact No. : " + customernumber, font1));
			hcell.setColspan(2);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(0);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Date : " + date , font1));
			hcell.setColspan(2);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setBorder(0);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase(" " , font4));
			hcell.setColspan(4);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
//			hcell.setBorderWidthTop(1);
			table.addCell(hcell);
			
			
			hcell = new PdfPCell(new Phrase("Dishname" , font4));
//			hcell.setColspan(3);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
			hcell.setBorderWidthTop(1);
//			hcell.setBorderWidthBottom(1);
			table.addCell(hcell);

			
			hcell = new PdfPCell(new Phrase("Quantity" , font4));
//			hcell.setColspan(3);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
			hcell.setBorderWidthTop(1);
//			hcell.setBorderWidthBottom(1);
			table.addCell(hcell);
			
			
			hcell = new PdfPCell(new Phrase("Rate" , font4));
//			hcell.setColspan(3);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
			hcell.setBorderWidthTop(1);
//			hcell.setBorderWidthBottom(1);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Sub-Total" , font4));
//			hcell.setColspan(3);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
			hcell.setBorderWidthTop(1);
//			hcell.setBorderWidthBottom(1);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase(" " , font1));
			hcell.setColspan(4);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
			hcell.setBorderWidthTop(1);
//			hcell.setBorderWidthBottom(1);
			table.addCell(hcell);
			
			for(int i = 0; i<orderdata.size(); i++)
			{
				
				Map map1 = orderdata.get(i);
				
				hcell = new PdfPCell(new Phrase(map1.get("dishname").toString() , font1));
//				hcell.setColspan(3);
				hcell.setRowspan(1);
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				hcell.setVerticalAlignment(Element.ALIGN_CENTER);
				hcell.setBorder(0);
//				hcell.setBorderWidthTop(1);
//				hcell.setBorderWidthBottom(1);
				table.addCell(hcell);

				hcell = new PdfPCell(new Phrase(map1.get("quantity").toString() , font1));
//				hcell.setColspan(3);
				hcell.setRowspan(1);
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				hcell.setVerticalAlignment(Element.ALIGN_CENTER);
				hcell.setBorder(0);
//				hcell.setBorderWidthTop(1);
//				hcell.setBorderWidthBottom(1);
				table.addCell(hcell);

				hcell = new PdfPCell(new Phrase("Rs. "+map1.get("rate").toString()+" /-" , font1));
//				hcell.setColspan(3);
				hcell.setRowspan(1);
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				hcell.setVerticalAlignment(Element.ALIGN_CENTER);
				hcell.setBorder(0);
//				hcell.setBorderWidthTop(1);
//				hcell.setBorderWidthBottom(1);
				table.addCell(hcell);
				
				hcell = new PdfPCell(new Phrase("Rs. "+map1.get("subtotal").toString()+" /-" , font1));
//				hcell.setColspan(3);
				hcell.setRowspan(1);
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				hcell.setVerticalAlignment(Element.ALIGN_CENTER);
				hcell.setBorder(0);
//				hcell.setBorderWidthTop(1);
//				hcell.setBorderWidthBottom(1);
				table.addCell(hcell);
			}
			
			hcell = new PdfPCell(new Phrase("Total" , font4));
			hcell.setColspan(2);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setVerticalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
//			hcell.setBorderWidthTop(1);
//			hcell.setBorderWidthBottom(1);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase(" " , font1));
			hcell.setColspan(1);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
//			hcell.setBorderWidthTop(1);
//			hcell.setBorderWidthBottom(1);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Rs. "+total+" /-" , font1));
			hcell.setColspan(1);
			hcell.setRowspan(1);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
//			hcell.setBorderWidthTop(1);
//			hcell.setBorderWidthBottom(1);
			table.addCell(hcell);
			
			document.add((Element) table);
			document.close();
			
		} catch (DocumentException ex) {
			ex.printStackTrace();
		}
		return bstream.toByteArray();
	}

	
}
