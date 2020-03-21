/**
 * 总额计算
 */
function countTotalPrice() {
    var totalPrices = document.getElementsByName("goodsTotalPrice");
    var totalPrice = document.getElementById("totalPrice");
    /* var goodsNums = document.getElementsByName("goodsNum");*/
    let goodsPrices = document.getElementsByName("goodsPrice");
    var sum = 0;


    for (var i = 0; i < totalPrices.length; i++) {
        /*总总额*/
        sum = sum + parseFloat(totalPrices[i].innerHTML.split("$")[1]);
        /* 每个商品总额
        let number = parseInt(goodsNums[i].value);
        otalPrices[i].innerHTML = number*parseFloat(goodsPrices[i].innerHTML.split("$")[1])*/
    }
    totalPrice.innerHTML = "$" + sum;
}

/**
 * 收货人信息模态框默认数据
 */
function consigneeModalDefaultData() {
    var consigneeName = document.getElementById("consigneeName");
    var consigneePhone = document.getElementById("consigneePhone");
    var consigneeAddress = document.getElementById("consigneeAddress");
    var modalConsigneeName = document.getElementById("modalConsigneeName");
    var modalConsigneePhone = document.getElementById("modalConsigneePhone");
    var modalConsigneeAddress = document.getElementById("modalConsigneeAddress");
    modalConsigneeName.value = consigneeName.innerHTML;
    modalConsigneePhone.value = consigneePhone.innerHTML;
    modalConsigneeAddress.value = consigneeAddress.innerHTML;
}

/**
 * 保存模态框数据
 */
function updateModataConsigneeData() {
    let consigneeName = document.getElementById("consigneeName");
    let consigneePhone = document.getElementById("consigneePhone");
    let consigneeAddress = document.getElementById("consigneeAddress");
    let modalConsigneeName = document.getElementById("modalConsigneeName");
    let modalConsigneePhone = document.getElementById("modalConsigneePhone");
    let modalConsigneeAddress = document.getElementById("modalConsigneeAddress");
    let updateConsigneeData = document.getElementById("updateConsigneeData");
    let modalConsigneeInfo = document.getElementById("modalConsigneeInfo");
    updateConsigneeData.onclick = function () {
        consigneeName.innerHTML = modalConsigneeName.value;
        consigneePhone.innerHTML = modalConsigneePhone.value;
        consigneeAddress.innerHTML = modalConsigneeAddress.value;
    }
}

/**
 * 确认订单，把数据保存到数据库
 */
function saveOrderInfo() {
    let saveOrderInfo = document.getElementById("saveOrderInfo");
    let sendTyprColumn = document.getElementsByName("sendType");
    let payTypeColumn = document.getElementsByName("payType");
    let sendType = jubgeRadio(sendTyprColumn);
    let payType = jubgeRadio(payTypeColumn);
    saveOrderInfo.onclick = function () {
        $.ajax({
            type: "POST",
            cache: false,
            url: "/saveOrderInfo",
            data: {
                consignee: document.getElementsByName("consignee")[0].innerHTML,
                phone: document.getElementsByName("phone")[0].innerHTML,
                receiverAdd: document.getElementsByName("receiverAdd")[0].innerHTML,
                payCountString: document.getElementsByName("payCount")[0].innerHTML,
                sendType: sendType,
                payType: payType,
            },
            success: function (orderId) {
                setCookie("orderId", orderId, 1);
                location.href = "order-success.html";
            },
            error: function () {
                // location.href = "error.html"
            }
        })
    }
}

/**
 *
 * @param name  cookie名称
 * @param value cookie存值
 * @param expirationTime 时间，请输入想要的天数,如：一天半输入1.5
 */
function setCookie(name, value, expirationTime) {
    var expiresTime = new Date();
    expiresTime.setTime(expiresTime.getTime() + expirationTime * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + value + ";" + "expires=" + expiresTime.toUTCString();
}

/**
 * 判断单选框选中的属性
 */
function jubgeRadio(RadioColumn) {
    let result;
    for (let i = 0; i < RadioColumn.length; i++) {
        let checked = RadioColumn[i].getAttribute("checked");
        if (checked === "checked") {

            result = RadioColumn[i].value;
        }

    }
    return result;

}

/**
 * 保存订单商品信息
 */
function saveOrderGoodsInfo() {
    let goodsNames = document.getElementsByName("goodsName");
    let goodsNums = document.getElementsByName("goodsNum");
    let goodsPrices = document.getElementsByName("goodsPrice");
    let goodsTotalPrices = document.getElementsByName("goodsTotalPrice");
    goodsNames = createArray(goodsNames);
    goodsNums = createArray(goodsNums);
    goodsPrices = createArray(goodsPrices);
    goodsTotalPrices  = createArray(goodsTotalPrices);
    var orderGoodsInfo = {
        goodsNames:goodsNames,
        goodsNums:goodsNums,
        goodsPrices:goodsPrices,
        goodsTotalPrices:goodsTotalPrices
    };
    $.ajax({
        type: "POST",
        cache:false,
        url:"/saveOrderGoodsInfo",
        dataType:"json",
        data:{
            orderGoodsInfo:JSON.stringify(orderGoodsInfo)
        },
        success:function () {

        },
        error:function () {

        }
        
        
    })
    
}

function createArray(obj){
   var array = [];
    for (let i = 0; i < obj.length; i++) {
        let innerHTML = obj[i].innerHTML;
        array.push(innerHTML)
    }
    return array;
}



onload = function () {


    countTotalPrice();
    consigneeModalDefaultData();
    updateModataConsigneeData();
    saveOrderInfo();
    saveOrderGoodsInfo();

};