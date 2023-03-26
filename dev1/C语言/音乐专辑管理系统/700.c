#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<conio.h>
typedef struct MUSIC
{
	char id[20];
	char name[50];
	char singer[50];
	char song[25];  
	struct Mus *next; //指向后继的指针 
}Mus,*pMus;  //后期会用到链表，先定义了结构指针 


void MusMenu(pMus Mushead);//音乐信息管理 
void AddMus(pMus Mushead);//录入新专辑 
void ReadMus(pMus Mushead);//读取音乐信息
void SaveDate(pMus Mushead);//音乐信息保存
void DisplayMus(pMus Mushead);//浏览所有音乐
void ChangeDate(pMus Mushead);//修改音乐 
void DeleteData(pMus Mushead);//删除音乐
void SearchMus(pMus Mushead);//音乐查询 
void MusNameSearch(pMus Mushead);//专辑名查询
void AccurateSearch(pMus Mushead);//专辑名精确查找
void FuzzySearch(pMus Mushead);//专辑名模糊查找
void MusIdSearch(pMus Mushead) ;//音乐编号查找 
void MussingerSearch(pMus Mushead) ;//歌手查询 
void MussongSearch(pMus Mushead) ;//按歌曲查询 



int main()
{	

  pMus Mushead; //建立一个头指针 
  MusMenu(Mushead); 
 return 0;
}

void MusMenu(pMus Mushead)//音乐信息管理菜单 
{
	
	Mushead=(pMus)malloc(sizeof(Mus));
	Mushead->next=NULL; //建立有头指针的空链表 
	int select; 
	char ch; 
	while(1)
	{
		printf("=================================\n");
	 	
		printf("\n****音乐信息管理****\n");
		
 		printf("\n请输入的对应序号进行相关操作\n");
 		
 		printf("\n1:录入新专辑信息\n");
 		
 		printf("\n2:修改音乐信息\n");
 		
	 	printf("\n3:删除音乐信息\n");
	 	
	 	printf("\n4:浏览全部音乐信息\n");
	 	
	 	printf("\n5:音乐信息查询\n");
	 	
 		printf("\n0:返回\n"); 
 		
 		printf("\n=================================\n");
 		
 		printf("请输入菜单项\n" );
 		scanf("%d",&select);
 		switch(select)
 		{
 			case 1:
 				system("CLS");
 				ReadMus( Mushead);
 				AddMus( Mushead);
 				SaveDate(Mushead);
 				break;
 			case 2:	
				system("CLS");
				ReadMus( Mushead);
				printf("当前音乐管理系统的专辑有\n\n") ;
 				DisplayMus(Mushead);
				ChangeDate(Mushead);
				SaveDate(Mushead);
            break ;
 			case 3:
				system("CLS");
 				ReadMus( Mushead);
 				printf("当前音乐管理系统的专辑有\n\n") ;
 				DisplayMus(Mushead);
				DeleteData( Mushead);
				SaveDate(Mushead);
 				break;
 			case 4:
 				system("CLS");
 				ReadMus( Mushead);
				DisplayMus(Mushead);
 				break;
 			case 5:
 				system("CLS");
 				SearchMus(Mushead);
 				break; 
 			case 0:
 				{
 				
		 			goto end;
		 			break; 
				 } 
 			default:printf("输入错误！\n");

		 }
		Warning();
	    printf("即将自动返回\n");
	    ch=getch(); //所在头文件conin.h,输入任何字符进入下一步，并输入的字符不会显示在屏幕上 
    	system("CLS");
	}
	end:; //结束文件 
}


void ReadMus(pMus Mushead)//读取音乐信息
{
	pMus p ,rear ; 
	FILE *fp;
	p=Mushead;
	fp=fopen("music.dat","rb");	
		 if(fp==NULL)
		 {
		 	printf("文件读入失败\n"); 
		 	exit(0);
		 }
		while(!feof(fp))   //直到文件访问结束
			 { 
			 rear=(pMus)malloc(sizeof(Mus));
			 fscanf(fp,"%s%s%s%s\n",rear->id,rear->name,
			 rear->singer,rear->song);  //格式化输入，遇到空格和回车结束
			 p->next=rear;                 
			 p=rear;//p向后移 
			 p->next=NULL;  //清除胡最后一次重复 
			 }
		
	 fclose(fp);
 }
 
void SaveDate(pMus Mushead)//音乐信息保存
{ 
			FILE *fp;
			fp=fopen("music.dat","wb"); 
			pMus p ; 
		
			p = Mushead->next ;  //p指向链表第一个节点 
		 	if(fp==NULL)
		 {
		 	printf("文件读入失败\n"); 
		 	exit(0);
		 }
			 while(p)
			 { 
				 fprintf(fp,"%s  %s  %s  %s\n",p->id,p->name,
				 p->singer,p->song);
				 
				 p = p->next ;  //指向下一个节点
			 } 
			fclose(fp);
}

void DisplayMus(pMus Mushead)//浏览音乐
{
	pMus p=Mushead->next;  //指向第一个节点
	char a[20]="音乐编号",b[50]="音乐名字",c[50]="音乐歌手" ,d[25]="音乐歌曲";
	printf("编号为：%s ；名称：s% ；歌手：s% ；歌曲：%s\n\n",a,b,c,d );
	while(p)
	{
		    
			printf("编号：%s",p->id );			
			printf("名称：%s",p->name);
			printf("歌手：%s",p->singer );
			printf("歌曲：%s",p->song );
			printf("\n");
		p=p->next;
	 } 
}

void AddMus(pMus Mushead)//录入新专辑 
{
	printf("请按提示输入相应的内容,如需结束录入请在音乐编号处输入“*”\n\n" );
	start:;
	int judje=0,i=0,j=0;
	pMus p,q,pre;    // p遍历整个链表，若pre不在链路中，则在q中进行插入 
	p=Mushead->next;  //建立新节点 
	pre=(pMus)malloc(sizeof(Mus));
			 printf("音乐编号：" );
			 scanf("%s" ,pre->id);
			 if(strcmp(pre->id,"*")==0)
			 	 {
			 	 	printf("录入完成\n");
				 	goto end;
				 	
				  } 
			 printf("音乐名字：" );
			 scanf("%s" ,pre->name);
			 printf("音乐歌手：" );
			 scanf("%s" ,pre->singer);
			 printf("音乐歌曲：" );
			 scanf("%s" ,pre->song);
	 		 printf("\n"); 
				while(p) //遍哩整个链路 
				{
				if(strcmp(p->id,pre->id)<0)  //输入数据不存在原链表中 
					i++;//键盘输入id成功次数加1 
					if(strcmp(p->id,pre->id)==0)
						{
							judje=1;
							break;
						}
						p=p->next;
				} 
				if(judje==1)
				printf("该音乐编号已存在\n");
				else{
					
					
						q=Mushead;
							while(q&&j<i)
							{
								q=q->next;
							j++;
						}

						pre->next=q->next;
						q->next=pre;  //插入，加入新结点
					printf("录入成功\n");
				}
	
	goto start ;
	end:;
	printf("正在保存中.........");
	SaveDate(Mushead);
	Sleep(10);
	MusMenu(Mushead); 
}

void DeleteData(pMus Mushead)//删除音乐
{
	start:;
	pMus q,p,pre;
	int i;
	pre=(pMus)malloc(sizeof(Mus));
	printf("请输入您需要删除的音乐编号,在音乐编号出输入“*”结束删除\n\n");
	printf("音乐编号："); 
	scanf("%s" ,pre->id);
		if(strcmp(pre->id,"*")==0)
		 {
			printf("删除完成\n");
			goto end;
				 	
	   	 }
	p=Mushead->next;

	
	for(q=NULL,p=Mushead;p;q=p,p=p->next) //用p遍历整个链表，q指向p的前一个结点 
	
	{

		if(strcmp(pre->id,p->id)==0)      //在链表中找到要删除的数据 
		{
			if(q)//删除第二个往后的结点 
			{
				i=1; 
				printf("删除成功\n\n");
				printf("删除的音乐信息为：\n\n");
						
				printf("音乐编号：%s\n",p->id );			
				printf("音乐名字：%s\n",p->name);
				printf("音乐歌手：%s\n",p->singer );
				printf("音乐歌曲：%s\n",p->song );
				printf("\n");
				q->next=p->next;
				goto start; 
			}else{                //删除第一个结点 
				Mushead=p->next;
				i=1;
			}
			free(p);
			break;
		}
		
		}
		if(i!=1)
		Warning();
		printf("没有该音乐，请检查您输入音乐编号是否正确！\n");
	end:;	
	
	printf("正在保存中.........");
	SaveDate(Mushead);
	Sleep(10);
	MusMenu(Mushead); 
} 
 
 void ChangeDate(pMus Mushead)//修改音乐
 {
 	start:;
 	pMus q,p,pre;
	int i=1;
	pre=(pMus)malloc(sizeof(Mus));
	printf("请输入待修改的音乐编号，在音乐编号出输入“*”结束修改:\n\n");
	printf("需要修改的音乐编号：");
	scanf("%s" ,pre->id);
	printf("\n"); 
	if(strcmp(pre->id,"*")==0)
	{                           
		printf("修改完成\n");
			goto end;
	}

	p=Mushead->next;	 //建立第一个结点
	while(p)	//该结点不为空
	{

		if(strcmp(pre->id,p->id)==0) //如果输入的id存在在原数据库中 则执行
		{ 
			i=0;				
				printf("请输入您需要的新专辑名字\n\n");
				printf("新专辑名字：");
				scanf("%s",pre->name);
				printf("\n");
				printf("请输入您需要的新专辑歌手\n\n");
				printf("新专辑歌手：");
				scanf("%s",pre->singer);
				printf("\n");
				printf("请输入您需要的新专辑发行的歌曲\n\n");
				printf("新专辑歌曲：");
				scanf("%s",pre->song);
				printf("\n");
				strcpy(p->name,pre->name);
				strcpy(p->singer,pre->singer);
				strcpy(p->song,pre->song);
				printf("修改成功\n");
				printf("修改后的音乐信息为\n\n");
				printf("专辑编号：%s\n",p->id );			
				printf("专辑名字：%s\n",p->name);
				printf("专辑歌手：%s\n",p->singer );
				printf("专辑歌曲：%s\n",p->song );
				printf("\n");
				goto start; 
			break;
		}
		p=p->next;
	}
		if(i==1)
		Warning();
		printf("没有该音乐，请检查您输入音乐编号是否正确！\n");
	end:;
	
	printf("正在保存中.........");
	SaveDate(Mushead);
	Sleep(10);
	MusMenu(Mushead); 
  } 
 
 void SearchMus(pMus Mushead)//音乐查询 
 {
	int select; 
	char ch;
	while(1)
	{
		printf("=================================\n");
	 	
		printf("\n******音乐信息查询******\n");
		
 		printf("\n请输入的对应序号进行相关操作\n");
 		
 		printf("\n1:按音乐编号查询\n");
 		
 		printf("\n2:按专辑名查询\n");
 		
 		printf("\n3:按歌手名查询\n");

	 	printf("\n4:按歌曲查询\n");
	 	
	 	
 		printf("\n0:返回\n"); 
 		
 		printf("\n=================================\n");
 		
 		printf("请输入菜单项\n" );
 		scanf("%d",&select);
 		switch(select)
 		{
 			case 1:
 				system("CLS");
 				MusIdSearch( Mushead);
 				break;
 			case 2:	
				system("CLS");
 				MusNameSearch(Mushead);
				
            break ;
 			case 3:
				system("CLS");
 				MussingerSearch(Mushead);
 				
 				break;
 			case 4:
 				system("CLS");
 				MussongSearch(Mushead);
				
 				break;
 			case 0:
 				{
 				
		 			goto end;
		 			break; 
				 } 
 			default:printf("输入错误！\n");

		 }
	  Warning();	 
	  printf("即将自动返回\n");
	ch=getch();
	system("CLS");
	}
	end:  ;
 }
 
void MusNameSearch(pMus Mushead)//专辑名查询
  {
  	int select; 
	char ch;
	while(1)
	{
		printf("=================================\n");
	 	
		printf("\n***按专辑名查询***\n");
		
 		printf("\n请输入的对应序号进行相关操作\n");
 		
 		printf("\n1:精确查找\n");
 		
 		printf("\n2:模糊查找\n");
	 	
 		printf("\n0:返回\n"); 
 		
 		printf("\n=================================\n");
 		
 		printf("请输入菜单项\n" );
 		scanf("%d",&select);
 		switch(select)
 		{
 			case 1:
 				system("CLS");
 				AccurateSearch( Mushead); 
 				break;
 			case 2:	
				system("CLS");
				FuzzySearch( Mushead); 
            break ; 
 			case 0:
 				{
 				
		 			goto end;
		 			break; 
				 } 
 			default:printf("输入错误！\n");

		 }
	  Warning(); 
	  printf("将自动返回\n");
	ch=getch();
	system("CLS");
	}
	end:  ;
   } 
   
void AccurateSearch(pMus Mushead)//专辑名精确查找
{
	ReadMus( Mushead);
	pMus q,p,pre;
	int i;
	pre=(pMus)malloc(sizeof(Mus));
	printf("请输在下方入您需要查询的专辑名字\n\n");
	printf("音乐专辑名："); 
	scanf("%s" ,pre->name);
	printf("\n");
	p=Mushead->next; //指向第一个数据的节点

	while(p)	//循环向后直到数据为空
	{
		if(strcmp(pre->name,p->name)==0) //如果鱼数据库里的数据一致 则执行
		{
				i=1; 
				printf("您查询的专辑为\n\n");			
				printf("专辑编号：%s\n",p->id );			
				printf("专辑名字：%s\n",p->name);
				printf("专辑歌手：%s\n",p->singer );
				printf("专辑歌曲：%s\n",p->song );
				printf("\n");
			}
		p=p->next; //当前没有找到 指针指向下一个节点
	}
		if(i!=1)
		Warning();
		printf("没有找到相关专辑，请检查您输入专辑名字是否正确！\n");
 } 
 
void MusIdSearch(pMus Mushead) //音乐编号查找 
 {
 	ReadMus( Mushead);
	pMus q,p,pre;
	int i;
	pre=(pMus)malloc(sizeof(Mus));
	printf("请输在下方入您需要查询的专辑编号\n\n");
	printf("专辑编号："); 
	scanf("%s" ,pre->id);
	printf("\n");
	p=Mushead->next;

	while(p)	
	{
		if(strcmp(pre->id,p->id)==0)
		{
				i=1; 
				printf("您查询的专辑为：\n\n");			
				printf("专辑编号：%s\n",p->id );			
				printf("专辑名字：%s\n",p->name);
				printf("专辑歌手：%s\n",p->singer );
				printf("专辑歌曲：%s\n",p->song );
				printf("\n");
			}
		p=p->next;
	}
		if(i!=1)
		Warning();
		printf("没有找到相关专辑，请检查您输入音乐名字是否正确！\n");
  }
  
void MussingerSearch(pMus Mushead) //歌手查询 
{
	ReadMus( Mushead);
	pMus q,p,pre;
	int i;
	char a[20]="音乐编号",b[50]="音乐名字",c[50]="音乐歌手" ,d[25]="音乐歌曲";
	
	pre=(pMus)malloc(sizeof(Mus));
	printf("请输在下方入您需要查询的歌手\n\n");
	printf("音乐歌手："); 
	scanf("%s" ,pre->singer);
	printf("\n");
	p=Mushead->next;
	q=Mushead->next;
	while(p)	
	{     //在节点不为空时，如果输入值与链路中的值一致，则输出1
		if(strcmp(pre->singer,p->singer)==0)
		{
			i=1;
		}
		p=p->next;
	}
	if(i==1)
	{
		printf("专辑编号：%s ；专辑名称：%s ；专辑歌手：%s ；专辑歌曲：%s\n\n",a,b,c,d );
		while(q){
			if(strcmp(pre->singer,q->singer)==0)
			{
							
				printf("专辑编号：%s\n",p->id );			
				printf("专辑名字：%s\n",p->name);
				printf("专辑歌手：%s\n",p->singer );
				printf("专辑歌曲：%s\n",p->song );

			printf("\n");
			}
			q=q->next;
		}
	 } 
		if(i!=1)
		Warning();
		printf("没有找到相关专辑籍，请检查您输入音乐的歌手是否正确！\n");
 } 

void MussongSearch(pMus Mushead) //歌曲查询 
{
	ReadMus( Mushead);
	pMus q,p,pre;
	int i;
	char a[20]="音乐编号",b[50]="音乐名字",c[50]="音乐歌手" ,d[25]="音乐歌曲";
	pre=(pMus)malloc(sizeof(Mus));
	printf("请输在下方入您需要查询的歌曲\n\n");
	printf("歌曲名字："); 
	scanf("%s" ,pre->song);
	printf("\n");
	p=Mushead->next;
	q=Mushead->next;
	while(p)	
	{
		if(strcmp(pre->song,p->song)==0)
		{
				i=1; 			
			}
		p=p->next;
	}
		if(i==1)
	{
		printf("专辑编号：%s ；专辑名称：%s ；专辑歌手：%s ；专辑歌曲：%s\n\n",a,b,c,d );
		while(q){
			if(strcmp(pre->song,q->song)==0)
			{
							
				printf("专辑编号：%s\n",p->id );			
				printf("专辑名字：%s\n",p->name);
				printf("专辑歌手：%s\n",p->singer );
				printf("专辑歌曲：%s\n",p->song );

			printf("\n");

			}
			q=q->next;
		}
	 } 
		if(i!=1)
		Warning();
		printf("没有找到相关专辑籍，请检查您输入的歌曲是否正确！\n");
 } 
 
void FuzzySearch(pMus Mushead)//专辑名模糊查找
 {
 	ReadMus( Mushead);
 	char ch[50];
 	char *p1=NULL,*q1=NULL;
	pMus q,p,pre;
	int i=0,j=0,count;
	char a[20]="音乐编号",b[50]="音乐名字",c[50]="音乐歌手" ,d[25]="音乐歌曲";
	pre=(pMus)malloc(sizeof(Mus));
	printf("请输在下方入您需要查询的关键词\n\n");
	printf("音乐专辑名："); 
	scanf("%s" ,ch);
	printf("\n");
	p=Mushead->next;
	q=Mushead->next;
	while(p)
	{
		q1=strstr(p->name,ch);  //如果ch是该节点的子式 则输出非零值		
			if(q1)
			{
				i=1;			
			}
		
		p=p->next;
	}
	
	if(i==1)  //若在这一步输出p 则得到的不是输入结果不匹配 而是p的后继。需要在确定完ch属于这个数据库后在进行输出。 
	{
		printf("专辑编号：%s ；专辑名：%s ；专辑歌手%s ；专辑歌曲：%s\n\n",a,b,c,d );
		while(q){
			p1=strstr(q->name,ch);
			if(p1)
			{		
				printf("专辑编号：%s\n",q->id );			
				printf("专辑名字：%s\n",q->name);
				printf("专辑歌手：%s\n",q->singer );
				printf("专辑歌曲：%s\n",q->song );

			printf("\n");
			}
			q=q->next;
		}
	 }
		if(i!=1)
		Warning();
		printf("没有找到相关专辑籍，请检查您输入的关键词是否正确！\n");
  } 
  
  
  void Warning()
 {
 
 printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");     
 printf(" ~··~~~~~~~~~~·~~~··``~~~~~~~~~~·~~\n");       
 printf("~~~···~·~~·~~~~~~~~~~·~~~·~~~~~~~~\n");         
 printf(" ~~O` ~o~~~~~~~~~~~~~|~~~~~~一一~~~~~~~~~\n"); 
 printf(" ~/|\ `i~\\~~~~~~╯╯╯~~~~~~~~╰~~~~~~~~\n");
 printf(" ~/~\~~/\~~\\~~~~~~~~~~~~~~~~~~╰一╮~~~~\n");
 printf(" ~~~~~~~~~~~~\\~~ ┏一┓~~~~~~~~~一╮~~~~\n");
 printf(" ~~~~~~~~~~~~~~╔(o  O)╗~~~~~~~~~~~~~~~~\n");
 printf(" ~~~~~~~~~~~~~~~\ ╰A╯/~~~~~~~~~~一╮~~~\n");
 printf(" ~~~~~~~~~~~~~~~~~│╬│~\\~~~~~~~~~~~~~~\n");
 printf(" ~~~~~~~~~~~~~~~~┃╬┃~~~~\\~~~~~~~~~~~~\n");
 printf(" ~~~~~~~~~~~~~~~~~┃╬┃~~~~\\~~~~~~~~~~~\n");
 printf(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
}


