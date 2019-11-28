window.addEventListener("load",()=>{
	course=document.querySelector(".Course");
	paymentType=document.querySelectorAll(".paymentType");
	for(let i=0;i<paymentType.length;++i){
		if(paymentType[i].value=="EMI"){
			installment=paymentType[i];
			break;
		}
	}
    calculator=document.querySelector("#calculator");
    regDate=document.querySelector("#reg-date");
    bdate=document.querySelector("#bdate");
    input=document.querySelectorAll("input");
    calcButton=document.querySelector("#calcButton");
    fees = document.querySelector("#fees");
    fees.readOnly=true;
    numberOfinst = document.querySelector("#numberOfinst");
    flag=true;
    dateconfig();
    for(i=0;i<input.length;++i){
        input[i].addEventListener("change",active);
    }
    course.addEventListener("change",updateFee)
});

function updateFee(){
	slctd=course.selectedIndex;
	fee=course[slctd].getAttribute("data-fee");
	fees.value=fee;
}

function active(){
    if(installment.checked==true){
        calculator.classList.add("active");
    }
    else if(installment.checked==false){
        calculator.classList.remove("active");
    }   
}
function dateconfig(){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();
    if(dd<10){
        dd='0'+dd
    } 
    if(mm<10){
        mm='0'+mm
    } 
    today = yyyy+'-'+mm+'-'+dd;
    regDate.setAttribute("max", today);
    max = (yyyy-18)+'-'+mm+'-'+dd;
    bdate.setAttribute("max",max);
}
function calculate() 
{ 
    if(fees.value>0&&numberOfinst.value>0&&numberOfinst.value<=6){
        calcButton.disabled=true;
        var dueDates=document.getElementsByClassName("dueDate");
        for(var i=dueDates.length-1 ; 0<=i ; --i){   
            dueDates[i].parentElement.removeChild(dueDates[i]);
        }
        numberOfinst.addEventListener("change",()=>{
            calcButton.disabled=false;
            flag=true;
        });
        numberOfinst.addEventListener("keyup",()=>{
            calcButton.disabled=false;
            flag=true;
        });
        res=parseInt(eval(fees.value/numberOfinst.value));
        document.querySelector("#result").innerHTML= "Monthly installment: "+res;
        for(var i=0;i<numberOfinst.value;++i){
            if(flag){
            input=document.createElement("input");
            var today=new Date();
            today.setDate(today.getDate()+(i*30));
            var month=((today.getMonth()+1)<10?'0'+(today.getMonth()+1):(today.getMonth()+1));
            var date=today.getDate()<10?'0'+today.getDate():today.getDate();
            var dueDate="#"+(i+1)+" Due date on: "+date+"/"+month+"/"+today.getFullYear();
            input.value=dueDate;
            input.readOnly=true;
            input.style.display="block";
            input.classList.add("dueDate");
            calculator.appendChild(input);
            }
        }
        flag=false
    }
    else if(numberOfinst.value>6){
        alert("Maximum 6 installments");
    }
    else{
        alert("Enter valid course fee or installments");
    }
}

function resetForm() {
    document.getElementById("calculator").classList.remove("active");
    var dueDates=document.getElementsByClassName("dueDate");
        for(var i=dueDates.length-1 ; 0<=i ; --i){   
            dueDates[i].parentElement.removeChild(dueDates[i]);
        }
    document.querySelector("#result").innerHTML="";
    calcButton.disabled=false;
}
