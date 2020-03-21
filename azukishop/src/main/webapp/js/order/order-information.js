/**
 * 页面加载时渲染订单信息
 */
function getList() {
    let orderId = getCookie("orderId");
    $.ajax({
        type: "GET",
        url: "/getOrderInfoById",
        data: {
            orderId: orderId
        },
        success: function (data) {
            var orderInfo = JSON.parse(data);
            orderList(orderInfo)
        },
        error: function () {
            // location.href="error.html";
        }
    });
    $.ajax({
        type: "GET",
        url: "/getOrderGoodsDetailByOrderId",
        data: {
            orderId: orderId
        },
        success: function (data) {
            var orderGoodseftailInfo = JSON.parse(data);
            renderOrderGoodsDetailInfo(orderGoodseftailInfo);


        },
        error: function (data) {
            // location.href = "error.html";
        }
    })
}

/**
 * 获取指定cookie
 * @param name cookie名称
 */
function getCookie(name) {
    let cookies = document.cookie;
    let cookieArray = cookies.split(",");
    for (let i = 0; i < cookieArray.length; i++) {
        let cookieNameAndValue = cookieArray[i].split("=");
        if (cookieNameAndValue[0] === name) {
            return cookieNameAndValue[1];
        }
    }
}


/**
 * 渲染订单数据
 */
function orderList(orderInfo) {
    let consignee = document.getElementById("consignee");
    let phone = document.getElementById("phone");
    let receiverAdd = document.getElementById("receiverAdd");
    let orderInfoId = document.getElementById("orderInfoId");
    let createDate = document.getElementById("createDate");
    let payType = document.getElementById("payType");
    consignee.innerHTML = orderInfo.consignee;
    phone.innerHTML = orderInfo.phone;
    receiverAdd.innerHTML = orderInfo.receiverAdd;
    orderInfoId.innerHTML = orderInfo.orderInfoId;
    createDate.innerHTML = orderInfo.created_date;
    payType.innerHTML = orderInfo.payType;
}

/**
 * 渲染订单商品信息
 */
function renderOrderGoodsDetailInfo(orderGoodsDetailInfo) {
    var tbody = document.getElementById("orderGoodsDetailInfo");
    var totalPrice = document.getElementById("totalPrice");
    let sum = 0;
    for (let i = 0; i < orderGoodsDetailInfo.length; i++) {
        let tr = document.createElement("tr");
        tbody.appendChild(tr);
        let goodsName = document.createElement("td");
        let goodsPicture = document.createElement("td");
        let goodsPrice = document.createElement("td");
        let goodsNum = document.createElement("td");
        let goodsTotalPrice = document.createElement("td");
        let empty = document.createElement("empty");
        goodsName.innerHTML = orderGoodsDetailInfo[i].goodsName;
        goodsName.class = "text-left";
        goodsPicture.innerHTML = orderGoodsDetailInfo[i].goodsPicture;
        goodsPicture.class = "text-left";
        goodsNum.innerHTML = orderGoodsDetailInfo[i].goodsNum;
        goodsNum.style.textAlign = "right";


        goodsPrice.innerHTML = "$" + orderGoodsDetailInfo[i].goodsPrice.toFixed(2);
        goodsPrice.style.textAlign = "right";
        goodsTotalPrice.innerHTML = "$" + orderGoodsDetailInfo[i].goodsTotalPrice.toFixed(2);
        if (orderGoodsDetailInfo[i].goodsTotalPrice > 0) {
            sum = sum + parseFloat(orderGoodsDetailInfo[i].goodsTotalPrice);
        }
        goodsTotalPrice.style.textAlign = "right";
        empty.style.width = "20px";
        tr.appendChild(goodsName);
        tr.appendChild(goodsPicture);
        tr.appendChild(goodsNum);
        tr.appendChild(goodsPrice);
        tr.appendChild(goodsTotalPrice);
        tr.appendChild(empty);
    }
    totalPrice.innerHTML = "$" + sum.toFixed(2);


}

/**
 * 总额计算
 * @type {HTMLElement}
 function countTotalPrice(){
    var sum = 0;
    orderGoodsDetailInfo.on()
    $("#orderGoodsDetailInfo").on('click','tr .totalPrices',function () {
        var totalPrice = document.getElementById("totalPrice");
    });

    console.log(totalPrices);
    console.log(totalPrices.length);
    for (let i = 0; i < totalPrices.length; i++) {
        let temp = parseFloat(totalPrices[i].innerHTML.split("$")[1]);
        console.log(temp);
        alert(temp);
        if (temp != 0){
            sum = sum+temp;
        }
    }
    totalPrice.innerHTML = "$"+sum.toFixed(2);
}*/

onload = function () {
    getList();


};




