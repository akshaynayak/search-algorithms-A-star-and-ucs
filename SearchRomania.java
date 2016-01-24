/**
 * 
 */

/**
 * @author Akshay Vasant Nayak(unity id : anayakv, student id: 200110688)
 * This is a java file. sample execution line is given below
 * java SearchRomania searchtype srccityname destcityname 
 */
import java.io.*;
import java.util.*;
public class SearchRomania{

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
String romania="road(oradea,    zerind,     71).  road(zerind,         arad,           75).road(arad,      timisoara, 118).  road(timisoara,      lugoj,         111).road(lugoj,     mehadia,    70).  road(dobreta,        mehadia,        75).road(oradea,    sibiu,     151).  road(arad,           sibiu,         140).road(dobreta,   craiova,   120).  road(sibiu,          rimnicu_vilcea, 80).road(sibiu,     fagaras,    99).  road(rimnicu_vilcea, craiova,       146).road(pitesti,   craiova,   138).  road(rimnicu_vilcea, pitesti,        97).road(bucharest, pitesti,   101).  road(bucharest,      fagaras,       211).road(bucharest, giurgiu,    90).  road(bucharest,      urziceni,       85).road(vaslui,    urziceni,  142).  road(hirsova,        urziceni,       98).road(hirsova,   eforie,     86).  road(vaslui,         iasi,           92).road(neamt,     iasi,       87)";
TreeSet<String> nodes=new TreeSet<String>();	
String spl[]=romania.split("\\.");
	//for(String x:spl)
	//System.out.println(x);
	for(String temp:spl)
	{
		String first_city=temp.substring(temp.indexOf('(')+1,temp.indexOf(','));
		String sc[]=temp.split(",");
		String second_city=sc[1].trim();
		nodes.add(first_city);
		nodes.add(second_city);
		
	}
	int edges[][]=new int[21][21];
	Iterator<String> i=nodes.iterator();
	LinkedList<String> nodeslist=new LinkedList<String>();
//	TreeMap<String,Boolean> explored=new TreeMap<String,Boolean>();
	
	while(i.hasNext())
	{
		String element=i.next();
		nodeslist.add(element);
	//	explored.put(element,false);
		
	}
	//System.out.println(explored);
	//System.out.println(nodeslist.indexOf("zerind"));
	
//	int n[][]=new int[21][21];
	for(int it=0;it<=20;it++)
		for(int j=1;j<=20;j++)
		edges[it][j]=0;
	
	for(String temp:spl)
	{
		String first_city=temp.substring(temp.indexOf('(')+1,temp.indexOf(','));
		int index1=nodeslist.indexOf(first_city);
		String sc[]=temp.split(",");
		String second_city=sc[1].trim();
		int index2=nodeslist.indexOf(second_city);
		edges[index1+1][index2+1]=edges[index2+1][index1+1]=1;
	}
	
	//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String searchtype=args[0];
	String srccity=args[1];
	String destcity=args[2];
	
	if(searchtype.equals("BFS"))
	{
		LinkedList<String> paths=new LinkedList<String>();
		LinkedList<String> exploredlist=new LinkedList<String>();
		LinkedList<String> visitedlist=new LinkedList<String>();
		
		LinkedList<LinkedList<String>> frontier=new LinkedList<LinkedList<String>>();
		paths.add(srccity);
		//exploredlist.add(srccity);

		//visitedlist.add(srccity);
		frontier.add(paths);
		while(true)
		{
			/*----------------- to see the expansion of search space uncomment the below line---------*/
			//System.out.println(frontier);
			if(frontier.peekFirst()==null)
			{	System.out.println("no solution");
				System.exit(0);
			}
				LinkedList<String> exppath=frontier.removeFirst();
				if(exppath.getLast().equals(destcity))
					{System.out.println("found");
					System.out.println("path"+exppath);
					System.out.println("number of expanded nodes:"+exploredlist.size());
					System.out.println("expandednodes"+exploredlist);
					System.exit(0);
					}
				
				exploredlist.add(exppath.getLast()); /*this line*/
				int expnodeindex=nodeslist.indexOf(exppath.getLast());
				//LinkedList<String> children=new LinkedList<String>();
				for(int f=1;f<=20;f++)
					if(edges[expnodeindex+1][f]==1)
					{
						//children.add(nodeslist.get(f-1));
						String child=nodeslist.get(f-1);
						if(exploredlist.indexOf(child)==-1 && visitedlist.indexOf(child)==-1)
						{//{if(child.equals(destcity))
							//{
							//	System.out.println("found"+exploredlist);
							//	System.exit(0);
							//	}
							//exploredlist.add(child);
							visitedlist.add(child);
							LinkedList<String> newchildpath=new LinkedList<String>(exppath);
							newchildpath.addLast(child);
							frontier.addLast(newchildpath);
						}
					}
					
			
		}
	}
	else if(searchtype.equals("DFS"))
	{
		LinkedList<String> paths=new LinkedList<String>();
		LinkedList<String> exploredlist=new LinkedList<String>();
		LinkedList<LinkedList<String>> frontier=new LinkedList<LinkedList<String>>();
		paths.add(srccity);
		//exploredlist.add(srccity);
		frontier.add(paths);
		while(true)
		{
			/*----------------- to see the expansion of search space uncomment the below line---------*/

			//System.out.println(frontier);
			if(frontier.peekFirst()==null)
			{	System.out.println("no solution");
				System.exit(0);
			}
				LinkedList<String> exppath=frontier.removeFirst();
				if(exppath.getLast().equals(destcity))
					{System.out.println("found");
					System.out.println("path="+exppath);
					System.out.println("expanded nodes size"+exploredlist.size());
					System.out.println("expanded nodes"+exploredlist);
					System.exit(0);
					}
				exploredlist.add(exppath.getLast());
				int expnodeindex=nodeslist.indexOf(exppath.getLast());
				//LinkedList<String> children=new LinkedList<String>();
				for(int f=20;f>=1;f--)
					if(edges[expnodeindex+1][f]==1)
					{
						//children.add(nodeslist.get(f-1));
						String child=nodeslist.get(f-1);
						if(exploredlist.indexOf(child)==-1)
						{//{if(child.equals(destcity))
							//{
							//	System.out.println("found"+exploredlist);
							//	System.exit(0);
							//	}
							//exploredlist.add(child);
							LinkedList<String> newchildpath=new LinkedList<String>(exppath);
							newchildpath.addLast(child);
							frontier.addFirst(newchildpath);
						}
					}
					
			
		}
			
		}
		
	}
	
	/*
	for(int it=1;it<=20;it++)
	{	for(int j=1;j<=20;j++)
		System.out.print(n[it][j]);
	System.out.println();
	}
	*/
	//System.out.println(nodeslist.size());
	//System.out.println(nodes);
	//System.out.println(nodes.size());
	//ArrayList<Integer> edges=new ArrayList<nodes.size()>();
	
	}


