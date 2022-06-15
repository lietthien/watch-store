<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
 <link rel="shortcut icon"
	href="<c:url value="/resources/images/logo/favicon.ico"/>"
	type="image/x-icon">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Product Detail</title>
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="main">
		<div class="product-details">
			<div class="product-details-img">
				<img
					src="<c:url value="/resources/images/products/${productdetail.image}"/>"
					alt="${productdetail.image} image"/>
				<c:if test="${productdetail.discountpercent>0}">
					<div class="discount-percent">-${productdetail.discountpercent}%</div>
				</c:if>
				<c:if test="${productdetail.status!='normal'}">
 					<div class="status">${productdetail.status}</div>
				</c:if> 
			</div>
			<div class="product-details-desc">
				<div class="product-brand-img">
					<img
						src="<c:url value="/resources/images/logo/${productdetail.brand}-logo.png"/>"
						alt="${productdetail.brand} brand img">
				</div>
				<p class="product-details-type">${productdetail.productname}
					${productdetail.brand} ${productdetail.symbolbrand}</p>
				<p>
					Thương hiệu: <span class="product-brand">${productdetail.brand}</span>
				</p>
				<c:if test="${productdetail.gendertype=='man'}">
					<p>
						Giới tính: <span class="product-gender">Nam</span>
					</p>
				</c:if>
				<c:if test="${productdetail.gendertype=='woman'}">
					<p>
						Giới tính: <span class="product-gender">Nữ</span>
					</p>
				</c:if>
				<c:if test="${productdetail.gendertype=='couple'}">
					<p>
						Giới tính: <span class="product-gender">Couple</span>
					</p>
				</c:if>
				<p>
					Loại máy: <span class="product-machine-type">${productdetail.machinetype}</span>
				</p>
				<p>
					Đường kính: <span class="product-diameter">${productdetail.diameter}mm</span>
				</p>
				<del>
					Giá: <span class="product-old-price"><fmt:formatNumber type="number" value="${productdetail.oldprice}"/>₫</span>
				</del>

				<p>
					Giá KM: <span class="product-price"><fmt:formatNumber type="number" value="${productdetail.discountprice}"/>₫</span>
				</p>
				<div>
					<a href="<c:url value="/user/addtocart/${productdetail.productid}"/>" class="add-to-cart-btn">Thêm vào giỏ hàng</a>
					<a href="<c:url value="/allproducts"/>" class="back-to-home-link">Tiếp tục mua hàng</a>
				</div>
			</div>
		</div>
		<div class="more-infor">
			<div class="more-info-tab">
				<span class="infor-item-link onfocus">mô tả chi tiết</span> <span
					class="infor-item-link">chế độ bảo hành</span>
			</div>
			<div class="infor-item-des onfocus">
				<p class="infor-item-des-title">thông tin sản phẩm</p>
				<table>
					<tbody>
						<tr class="tr-0">
							<td class="title-characteristic">Giới tính</td>
							<c:if test="${productdetail.gendertype=='man'}">
							<td class="content-characteristic">Nam</td>
							</c:if>
							
							<c:if test="${productdetail.gendertype=='woman'}">
							<td class="content-characteristic">Nữ</td>
							</c:if>
							
							<c:if test="${productdetail.gendertype=='couple'}">
							<td class="content-characteristic">Couple</td>
							</c:if>
						</tr>
						<tr class="tr-0">
							<td class="title-characteristic">Loại máy</td>
							<td class="content-characteristic">${productdetail.machinetype}</td>
						</tr>
						<tr class="tr-0">
							<td class="title-characteristic">Mặt kính</td>
							<td class="content-characteristic">${productdetail.glass}</td>
						</tr>
						<tr class="tr-0">
							<td class="title-characteristic">Chất liệu vỏ</td>
							<td class="content-characteristic">${productdetail.material}</td>
						</tr>

						<tr class="tr-0">
							<td class="title-characteristic">Độ chịu nước</td>
							<td class="content-characteristic">30m</td>
						</tr>
						<tr class="tr-0">
							<td class="title-characteristic">Xuất xứ</td>
							<td class="content-characteristic">${productdetail.original}</td>
						</tr>
						<tr class="tr-0">
							<td class="title-characteristic">Màu mặt</td>
							<td class="content-characteristic">Đen</td>
						</tr>
						<tr class="tr-1">
							<td class="title-characteristic">Kiểu dáng</td>
							<td class="content-characteristic">Mặt tròn</td>
						</tr>
						<tr class="tr-1">
							<td class="title-characteristic">Phong cách</td>
							<td class="content-characteristic">Sang trọng</td>
						</tr>
						<tr class="tr-1">
							<td class="title-characteristic">Đường kính</td>
							<td class="content-characteristic">${productdetail.diameter}mm</td>
						</tr>
						<tr class="tr-1">
							<td class="title-characteristic">Độ dày</td>
							<td class="content-characteristic">9.8mm</td>
						</tr>
						<tr class="tr-1">
							<td class="title-characteristic">Size dây</td>
							<td class="content-characteristic">21mm</td>
						</tr>
						<tr class="tr-1">
							<td class="title-characteristic">Lug to lug</td>
							<td class="content-characteristic">47mm</td>
						</tr>
						<tr class="tr-1">
							<td class="title-characteristic">Bảo hành quốc tế</td>
							<td class="content-characteristic">5 năm chính hãng</td>
						</tr>


					</tbody>
				</table>
			</div>
			<div class="infor-item-des">
				<p class="warranty-policy">
					Theo chính sách bảo hành của các hãng đồng hồ, tất cả các đồng hồ
					chính hãng bán ra đều kèm theo 01 thẻ/ sổ/ giấy bảo hành Quốc tế có
					giá trị bảo hành theo thời gian qui định của từng hãng đồng hồ khác
					nhau.<br> Mỗi thẻ/ sổ/ giấy bảo hành chỉ được phát hành kèm
					theo mỗi chiếc đồng hồ bán ra một lần duy nhất và không cấp lại
					dưới bất kỳ hình thức nào.
				</p>
				<p class="warranty-policy">
					- Bảo hành chỉ có giá trị khi đồng hồ có thẻ/ sổ/ giấy bảo hành
					chính thức đi kèm. Thẻ/ sổ/ giấy bảo hành phải được ghi đầy đủ và
					chính xác các thông tin như: Mã số đồng hồ, mã đáy đồng hồ (nếu
					có), địa chỉ bán, ngày mua hàng, ....Thẻ/ sổ/ giấy bảo hành phải
					được đóng dấu của Đại lý ủy quyền chính thức hoặc Cửa hàng bán ra.<br>
					- Thời gian bảo hành của đồng hồ được tính kể từ ngày mua ghi trên
					thẻ/ sổ/ giấy bảo hành và không được gia hạn sau khi hết thời hạn
					bảo hành. Cụ thể như sau:<br> + Thời hạn bảo hành theo tiêu
					chuẩn Quốc tế của các hãng Đồng hồ Nhật Bản là 1 năm (riêng đối với
					đồng hồ Orient Star là 2 năm). Bao gồm các thương hiệu: Seiko,
					Citizen, Orient.<br> + Thời hạn bảo hành theo tiêu chuẩn Quốc
					tế của các hãng Đồng hồ Thụy Sỹ là 2 năm (riêng đối với dòng máy
					Chronometer của Tissot, Mido là 3 năm). Bao gồm các thương hiệu:
					Longines, Mido, Tissot, Calvin Klein, Frederique Constant, Certina,
					Claude Bernard, Rotary, Charriol, Candino.<br> + Các thương
					hiệu khác có chế độ bảo hành riêng như sau: 2 năm đối với thương
					hiệu Daniel Wellington, Freelook, Olympia Star, Olym Pianus và bảo
					hành máy trọn đời đối với thương hiệu Skagen.<br> - Chỉ bảo
					hành miễn phí cho trường hợp hư hỏng về máy và các linh kiện bên
					trong của đồng hồ khi được xác định là do lỗi của nhà sản xuất.<br>
					- Chỉ bảo hành, sửa chữa hoặc thay thế mới cho các linh kiện bên
					trong đồng hồ. Không thay thế hoặc đổi bằng 1 chiếc đồng hồ khác.<br>
					<br> Lưu ý: Đặc thù của đồng hồ là không có kết nối với mạng
					máy tính bên ngoài nên không thể áp dụng Bảo hành điện tử như điện
					thoại, máy tính, …. Quý khách vui lòng lưu trữ, bảo quản kỹ lượng
					thẻ/ sổ/ giấy bảo hành để được hưởng đầy đủ quyền lợi bảo hành cam
					kết mua hàng. Duy Anh và các Trung tâm bảo hành Quốc tế của hãng có
					quyền từ chối bảo hành khi Quý khách không cung cấp được thẻ/ sổ/
					giấy bảo hành Quốc tế đi kèm sản phẩm.
				</p>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>

</html>