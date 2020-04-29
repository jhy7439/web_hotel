	$(function(){
		var count=0;	
		var i=0;
		var plus=1;
		$("#resPagerContent>p>span").text(count+plus+"/"+"5");
		$("#resPagerTitle>h1").text('asdasdsadasdassadsaddasd');
		$("#resPagerContent>p>button:first-child").on("click",function(){
			
			i =-(count*510);
			count--;
			
			$("#imgList>img").animate({top:i+'px'});
			
			if(count<=-1){
				count=0;
				plus--;
				if(plus==0){
					plus=1;
				}
			}
		
			$("#resPagerContent>p>span").text(count+plus+"/"+"5");
			if(count+plus==1){
				$("#resPagerTitle>h1").text('asdasdsadasdassadsaddasd');
			
			}else if(count+plus==2){
				$("#resPagerTitle>h1").text('이탈리아의 풍미를 더한 피아토 우니코');
			
			}else if(count+plus==3){
				$("#resPagerTitle>h1").text('dddddddddddddddddd');
			
			}else if(count+plus==4){
				$("#resPagerTitle>h1").text('asdasdsfffffffffffffffffffffffffsd');
	
			}else if(count+plus==5){
				$("#resPagerTitle>h1").text('asdasqweeeeeeeeeeeeeeeeeeeeeesd');
		
			}
			
						
		});
		$("#resPagerContent>p>button:nth-child(3)").on("click",function(){

			
			count+=1;
			i = -(count*510);
			$("#imgList>img").animate({top:i+'px'});
			if(count>=4){
				count=3;
				plus++;
				if(plus==3){
					plus=2;
				}
			}
			
			$("#resPagerContent>p>span").text(count+plus+"/"+"5");
			
			if(count+plus==1){
				$("#resPagerTitle>h1").text('asdasdsadasdassadsaddasd');
		
			}else if(count+plus==2){
				$("#resPagerTitle>h1").text('이탈리아의 풍미를 더한 피아토 우니코');
		
			}else if(count+plus==3){
				$("#resPagerTitle>h1").text('dddddddddddddddddd');
	
			}else if(count+plus==4){
				$("#resPagerTitle>h1").text('asdasdsfffffffffffffffffffffffffsd');
			
			}else if(count+plus==5){
				$("#resPagerTitle>h1").text('asdasqweeeeeeeeeeeeeeeeeeeeeesd');
	
			}
			
		});
		
		
		
	});
	
	
	
	
	
	
	
	
	
	