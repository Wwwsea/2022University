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
	struct Mus *next; //ָ���̵�ָ�� 
}Mus,*pMus;  //���ڻ��õ������ȶ����˽ṹָ�� 


void MusMenu(pMus Mushead);//������Ϣ���� 
void AddMus(pMus Mushead);//¼����ר�� 
void ReadMus(pMus Mushead);//��ȡ������Ϣ
void SaveDate(pMus Mushead);//������Ϣ����
void DisplayMus(pMus Mushead);//�����������
void ChangeDate(pMus Mushead);//�޸����� 
void DeleteData(pMus Mushead);//ɾ������
void SearchMus(pMus Mushead);//���ֲ�ѯ 
void MusNameSearch(pMus Mushead);//ר������ѯ
void AccurateSearch(pMus Mushead);//ר������ȷ����
void FuzzySearch(pMus Mushead);//ר����ģ������
void MusIdSearch(pMus Mushead) ;//���ֱ�Ų��� 
void MussingerSearch(pMus Mushead) ;//���ֲ�ѯ 
void MussongSearch(pMus Mushead) ;//��������ѯ 



int main()
{	

  pMus Mushead; //����һ��ͷָ�� 
  MusMenu(Mushead); 
 return 0;
}

void MusMenu(pMus Mushead)//������Ϣ����˵� 
{
	
	Mushead=(pMus)malloc(sizeof(Mus));
	Mushead->next=NULL; //������ͷָ��Ŀ����� 
	int select; 
	char ch; 
	while(1)
	{
		printf("=================================\n");
	 	
		printf("\n****������Ϣ����****\n");
		
 		printf("\n������Ķ�Ӧ��Ž�����ز���\n");
 		
 		printf("\n1:¼����ר����Ϣ\n");
 		
 		printf("\n2:�޸�������Ϣ\n");
 		
	 	printf("\n3:ɾ��������Ϣ\n");
	 	
	 	printf("\n4:���ȫ��������Ϣ\n");
	 	
	 	printf("\n5:������Ϣ��ѯ\n");
	 	
 		printf("\n0:����\n"); 
 		
 		printf("\n=================================\n");
 		
 		printf("������˵���\n" );
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
				printf("��ǰ���ֹ���ϵͳ��ר����\n\n") ;
 				DisplayMus(Mushead);
				ChangeDate(Mushead);
				SaveDate(Mushead);
            break ;
 			case 3:
				system("CLS");
 				ReadMus( Mushead);
 				printf("��ǰ���ֹ���ϵͳ��ר����\n\n") ;
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
 			default:printf("�������\n");

		 }
		Warning();
	    printf("�����Զ�����\n");
	    ch=getch(); //����ͷ�ļ�conin.h,�����κ��ַ�������һ������������ַ�������ʾ����Ļ�� 
    	system("CLS");
	}
	end:; //�����ļ� 
}


void ReadMus(pMus Mushead)//��ȡ������Ϣ
{
	pMus p ,rear ; 
	FILE *fp;
	p=Mushead;
	fp=fopen("music.dat","rb");	
		 if(fp==NULL)
		 {
		 	printf("�ļ�����ʧ��\n"); 
		 	exit(0);
		 }
		while(!feof(fp))   //ֱ���ļ����ʽ���
			 { 
			 rear=(pMus)malloc(sizeof(Mus));
			 fscanf(fp,"%s%s%s%s\n",rear->id,rear->name,
			 rear->singer,rear->song);  //��ʽ�����룬�����ո�ͻس�����
			 p->next=rear;                 
			 p=rear;//p����� 
			 p->next=NULL;  //��������һ���ظ� 
			 }
		
	 fclose(fp);
 }
 
void SaveDate(pMus Mushead)//������Ϣ����
{ 
			FILE *fp;
			fp=fopen("music.dat","wb"); 
			pMus p ; 
		
			p = Mushead->next ;  //pָ�������һ���ڵ� 
		 	if(fp==NULL)
		 {
		 	printf("�ļ�����ʧ��\n"); 
		 	exit(0);
		 }
			 while(p)
			 { 
				 fprintf(fp,"%s  %s  %s  %s\n",p->id,p->name,
				 p->singer,p->song);
				 
				 p = p->next ;  //ָ����һ���ڵ�
			 } 
			fclose(fp);
}

void DisplayMus(pMus Mushead)//�������
{
	pMus p=Mushead->next;  //ָ���һ���ڵ�
	char a[20]="���ֱ��",b[50]="��������",c[50]="���ָ���" ,d[25]="���ָ���";
	printf("���Ϊ��%s �����ƣ�s% �����֣�s% ��������%s\n\n",a,b,c,d );
	while(p)
	{
		    
			printf("��ţ�%s",p->id );			
			printf("���ƣ�%s",p->name);
			printf("���֣�%s",p->singer );
			printf("������%s",p->song );
			printf("\n");
		p=p->next;
	 } 
}

void AddMus(pMus Mushead)//¼����ר�� 
{
	printf("�밴��ʾ������Ӧ������,�������¼���������ֱ�Ŵ����롰*��\n\n" );
	start:;
	int judje=0,i=0,j=0;
	pMus p,q,pre;    // p��������������pre������·�У�����q�н��в��� 
	p=Mushead->next;  //�����½ڵ� 
	pre=(pMus)malloc(sizeof(Mus));
			 printf("���ֱ�ţ�" );
			 scanf("%s" ,pre->id);
			 if(strcmp(pre->id,"*")==0)
			 	 {
			 	 	printf("¼�����\n");
				 	goto end;
				 	
				  } 
			 printf("�������֣�" );
			 scanf("%s" ,pre->name);
			 printf("���ָ��֣�" );
			 scanf("%s" ,pre->singer);
			 printf("���ָ�����" );
			 scanf("%s" ,pre->song);
	 		 printf("\n"); 
				while(p) //����������· 
				{
				if(strcmp(p->id,pre->id)<0)  //�������ݲ�����ԭ������ 
					i++;//��������id�ɹ�������1 
					if(strcmp(p->id,pre->id)==0)
						{
							judje=1;
							break;
						}
						p=p->next;
				} 
				if(judje==1)
				printf("�����ֱ���Ѵ���\n");
				else{
					
					
						q=Mushead;
							while(q&&j<i)
							{
								q=q->next;
							j++;
						}

						pre->next=q->next;
						q->next=pre;  //���룬�����½��
					printf("¼��ɹ�\n");
				}
	
	goto start ;
	end:;
	printf("���ڱ�����.........");
	SaveDate(Mushead);
	Sleep(10);
	MusMenu(Mushead); 
}

void DeleteData(pMus Mushead)//ɾ������
{
	start:;
	pMus q,p,pre;
	int i;
	pre=(pMus)malloc(sizeof(Mus));
	printf("����������Ҫɾ�������ֱ��,�����ֱ�ų����롰*������ɾ��\n\n");
	printf("���ֱ�ţ�"); 
	scanf("%s" ,pre->id);
		if(strcmp(pre->id,"*")==0)
		 {
			printf("ɾ�����\n");
			goto end;
				 	
	   	 }
	p=Mushead->next;

	
	for(q=NULL,p=Mushead;p;q=p,p=p->next) //��p������������qָ��p��ǰһ����� 
	
	{

		if(strcmp(pre->id,p->id)==0)      //���������ҵ�Ҫɾ�������� 
		{
			if(q)//ɾ���ڶ�������Ľ�� 
			{
				i=1; 
				printf("ɾ���ɹ�\n\n");
				printf("ɾ����������ϢΪ��\n\n");
						
				printf("���ֱ�ţ�%s\n",p->id );			
				printf("�������֣�%s\n",p->name);
				printf("���ָ��֣�%s\n",p->singer );
				printf("���ָ�����%s\n",p->song );
				printf("\n");
				q->next=p->next;
				goto start; 
			}else{                //ɾ����һ����� 
				Mushead=p->next;
				i=1;
			}
			free(p);
			break;
		}
		
		}
		if(i!=1)
		Warning();
		printf("û�и����֣��������������ֱ���Ƿ���ȷ��\n");
	end:;	
	
	printf("���ڱ�����.........");
	SaveDate(Mushead);
	Sleep(10);
	MusMenu(Mushead); 
} 
 
 void ChangeDate(pMus Mushead)//�޸�����
 {
 	start:;
 	pMus q,p,pre;
	int i=1;
	pre=(pMus)malloc(sizeof(Mus));
	printf("��������޸ĵ����ֱ�ţ������ֱ�ų����롰*�������޸�:\n\n");
	printf("��Ҫ�޸ĵ����ֱ�ţ�");
	scanf("%s" ,pre->id);
	printf("\n"); 
	if(strcmp(pre->id,"*")==0)
	{                           
		printf("�޸����\n");
			goto end;
	}

	p=Mushead->next;	 //������һ�����
	while(p)	//�ý�㲻Ϊ��
	{

		if(strcmp(pre->id,p->id)==0) //��������id������ԭ���ݿ��� ��ִ��
		{ 
			i=0;				
				printf("����������Ҫ����ר������\n\n");
				printf("��ר�����֣�");
				scanf("%s",pre->name);
				printf("\n");
				printf("����������Ҫ����ר������\n\n");
				printf("��ר�����֣�");
				scanf("%s",pre->singer);
				printf("\n");
				printf("����������Ҫ����ר�����еĸ���\n\n");
				printf("��ר��������");
				scanf("%s",pre->song);
				printf("\n");
				strcpy(p->name,pre->name);
				strcpy(p->singer,pre->singer);
				strcpy(p->song,pre->song);
				printf("�޸ĳɹ�\n");
				printf("�޸ĺ��������ϢΪ\n\n");
				printf("ר����ţ�%s\n",p->id );			
				printf("ר�����֣�%s\n",p->name);
				printf("ר�����֣�%s\n",p->singer );
				printf("ר��������%s\n",p->song );
				printf("\n");
				goto start; 
			break;
		}
		p=p->next;
	}
		if(i==1)
		Warning();
		printf("û�и����֣��������������ֱ���Ƿ���ȷ��\n");
	end:;
	
	printf("���ڱ�����.........");
	SaveDate(Mushead);
	Sleep(10);
	MusMenu(Mushead); 
  } 
 
 void SearchMus(pMus Mushead)//���ֲ�ѯ 
 {
	int select; 
	char ch;
	while(1)
	{
		printf("=================================\n");
	 	
		printf("\n******������Ϣ��ѯ******\n");
		
 		printf("\n������Ķ�Ӧ��Ž�����ز���\n");
 		
 		printf("\n1:�����ֱ�Ų�ѯ\n");
 		
 		printf("\n2:��ר������ѯ\n");
 		
 		printf("\n3:����������ѯ\n");

	 	printf("\n4:��������ѯ\n");
	 	
	 	
 		printf("\n0:����\n"); 
 		
 		printf("\n=================================\n");
 		
 		printf("������˵���\n" );
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
 			default:printf("�������\n");

		 }
	  Warning();	 
	  printf("�����Զ�����\n");
	ch=getch();
	system("CLS");
	}
	end:  ;
 }
 
void MusNameSearch(pMus Mushead)//ר������ѯ
  {
  	int select; 
	char ch;
	while(1)
	{
		printf("=================================\n");
	 	
		printf("\n***��ר������ѯ***\n");
		
 		printf("\n������Ķ�Ӧ��Ž�����ز���\n");
 		
 		printf("\n1:��ȷ����\n");
 		
 		printf("\n2:ģ������\n");
	 	
 		printf("\n0:����\n"); 
 		
 		printf("\n=================================\n");
 		
 		printf("������˵���\n" );
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
 			default:printf("�������\n");

		 }
	  Warning(); 
	  printf("���Զ�����\n");
	ch=getch();
	system("CLS");
	}
	end:  ;
   } 
   
void AccurateSearch(pMus Mushead)//ר������ȷ����
{
	ReadMus( Mushead);
	pMus q,p,pre;
	int i;
	pre=(pMus)malloc(sizeof(Mus));
	printf("�������·�������Ҫ��ѯ��ר������\n\n");
	printf("����ר������"); 
	scanf("%s" ,pre->name);
	printf("\n");
	p=Mushead->next; //ָ���һ�����ݵĽڵ�

	while(p)	//ѭ�����ֱ������Ϊ��
	{
		if(strcmp(pre->name,p->name)==0) //��������ݿ��������һ�� ��ִ��
		{
				i=1; 
				printf("����ѯ��ר��Ϊ\n\n");			
				printf("ר����ţ�%s\n",p->id );			
				printf("ר�����֣�%s\n",p->name);
				printf("ר�����֣�%s\n",p->singer );
				printf("ר��������%s\n",p->song );
				printf("\n");
			}
		p=p->next; //��ǰû���ҵ� ָ��ָ����һ���ڵ�
	}
		if(i!=1)
		Warning();
		printf("û���ҵ����ר��������������ר�������Ƿ���ȷ��\n");
 } 
 
void MusIdSearch(pMus Mushead) //���ֱ�Ų��� 
 {
 	ReadMus( Mushead);
	pMus q,p,pre;
	int i;
	pre=(pMus)malloc(sizeof(Mus));
	printf("�������·�������Ҫ��ѯ��ר�����\n\n");
	printf("ר����ţ�"); 
	scanf("%s" ,pre->id);
	printf("\n");
	p=Mushead->next;

	while(p)	
	{
		if(strcmp(pre->id,p->id)==0)
		{
				i=1; 
				printf("����ѯ��ר��Ϊ��\n\n");			
				printf("ר����ţ�%s\n",p->id );			
				printf("ר�����֣�%s\n",p->name);
				printf("ר�����֣�%s\n",p->singer );
				printf("ר��������%s\n",p->song );
				printf("\n");
			}
		p=p->next;
	}
		if(i!=1)
		Warning();
		printf("û���ҵ����ר�����������������������Ƿ���ȷ��\n");
  }
  
void MussingerSearch(pMus Mushead) //���ֲ�ѯ 
{
	ReadMus( Mushead);
	pMus q,p,pre;
	int i;
	char a[20]="���ֱ��",b[50]="��������",c[50]="���ָ���" ,d[25]="���ָ���";
	
	pre=(pMus)malloc(sizeof(Mus));
	printf("�������·�������Ҫ��ѯ�ĸ���\n\n");
	printf("���ָ��֣�"); 
	scanf("%s" ,pre->singer);
	printf("\n");
	p=Mushead->next;
	q=Mushead->next;
	while(p)	
	{     //�ڽڵ㲻Ϊ��ʱ���������ֵ����·�е�ֵһ�£������1
		if(strcmp(pre->singer,p->singer)==0)
		{
			i=1;
		}
		p=p->next;
	}
	if(i==1)
	{
		printf("ר����ţ�%s ��ר�����ƣ�%s ��ר�����֣�%s ��ר��������%s\n\n",a,b,c,d );
		while(q){
			if(strcmp(pre->singer,q->singer)==0)
			{
							
				printf("ר����ţ�%s\n",p->id );			
				printf("ר�����֣�%s\n",p->name);
				printf("ר�����֣�%s\n",p->singer );
				printf("ר��������%s\n",p->song );

			printf("\n");
			}
			q=q->next;
		}
	 } 
		if(i!=1)
		Warning();
		printf("û���ҵ����ר�������������������ֵĸ����Ƿ���ȷ��\n");
 } 

void MussongSearch(pMus Mushead) //������ѯ 
{
	ReadMus( Mushead);
	pMus q,p,pre;
	int i;
	char a[20]="���ֱ��",b[50]="��������",c[50]="���ָ���" ,d[25]="���ָ���";
	pre=(pMus)malloc(sizeof(Mus));
	printf("�������·�������Ҫ��ѯ�ĸ���\n\n");
	printf("�������֣�"); 
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
		printf("ר����ţ�%s ��ר�����ƣ�%s ��ר�����֣�%s ��ר��������%s\n\n",a,b,c,d );
		while(q){
			if(strcmp(pre->song,q->song)==0)
			{
							
				printf("ר����ţ�%s\n",p->id );			
				printf("ר�����֣�%s\n",p->name);
				printf("ר�����֣�%s\n",p->singer );
				printf("ר��������%s\n",p->song );

			printf("\n");

			}
			q=q->next;
		}
	 } 
		if(i!=1)
		Warning();
		printf("û���ҵ����ר����������������ĸ����Ƿ���ȷ��\n");
 } 
 
void FuzzySearch(pMus Mushead)//ר����ģ������
 {
 	ReadMus( Mushead);
 	char ch[50];
 	char *p1=NULL,*q1=NULL;
	pMus q,p,pre;
	int i=0,j=0,count;
	char a[20]="���ֱ��",b[50]="��������",c[50]="���ָ���" ,d[25]="���ָ���";
	pre=(pMus)malloc(sizeof(Mus));
	printf("�������·�������Ҫ��ѯ�Ĺؼ���\n\n");
	printf("����ר������"); 
	scanf("%s" ,ch);
	printf("\n");
	p=Mushead->next;
	q=Mushead->next;
	while(p)
	{
		q1=strstr(p->name,ch);  //���ch�Ǹýڵ����ʽ ���������ֵ		
			if(q1)
			{
				i=1;			
			}
		
		p=p->next;
	}
	
	if(i==1)  //������һ�����p ��õ��Ĳ�����������ƥ�� ����p�ĺ�̡���Ҫ��ȷ����ch����������ݿ���ڽ�������� 
	{
		printf("ר����ţ�%s ��ר������%s ��ר������%s ��ר��������%s\n\n",a,b,c,d );
		while(q){
			p1=strstr(q->name,ch);
			if(p1)
			{		
				printf("ר����ţ�%s\n",q->id );			
				printf("ר�����֣�%s\n",q->name);
				printf("ר�����֣�%s\n",q->singer );
				printf("ר��������%s\n",q->song );

			printf("\n");
			}
			q=q->next;
		}
	 }
		if(i!=1)
		Warning();
		printf("û���ҵ����ר����������������Ĺؼ����Ƿ���ȷ��\n");
  } 
  
  
  void Warning()
 {
 
 printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");     
 printf(" ~����~~~~~~~~~~��~~~����``~~~~~~~~~~��~~\n");       
 printf("~~~������~��~~��~~~~~~~~~~��~~~��~~~~~~~~\n");         
 printf(" ~~O` ~o~~~~~~~~~~~~~|~~~~~~һһ~~~~~~~~~\n"); 
 printf(" ~/|\ `i~\\~~~~~~�s�s�s~~~~~~~~�t~~~~~~~~\n");
 printf(" ~/~\~~/\~~\\~~~~~~~~~~~~~~~~~~�tһ�r~~~~\n");
 printf(" ~~~~~~~~~~~~\\~~ ��һ��~~~~~~~~~һ�r~~~~\n");
 printf(" ~~~~~~~~~~~~~~�X(o  O)�[~~~~~~~~~~~~~~~~\n");
 printf(" ~~~~~~~~~~~~~~~\ �tA�s/~~~~~~~~~~һ�r~~~\n");
 printf(" ~~~~~~~~~~~~~~~~~���p��~\\~~~~~~~~~~~~~~\n");
 printf(" ~~~~~~~~~~~~~~~~���p��~~~~\\~~~~~~~~~~~~\n");
 printf(" ~~~~~~~~~~~~~~~~~���p��~~~~\\~~~~~~~~~~~\n");
 printf(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
}


