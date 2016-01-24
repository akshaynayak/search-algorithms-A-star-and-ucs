/*

name akshay nayak
unity id anayakv


*/
import java.io.*;
import java.util.*;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import java.lang.*;
import java.lang.reflect.Array;
public class SearchUSA {
	
public static void main(String args[])
{
	String USA="road(albanyNY, montreal, 226). road(albanyNY, boston, 166). road(albanyNY, rochester, 148).road(albanyGA, tallahassee, 120). road(albanyGA, macon, 106).road(albuquerque, elPaso, 267).  road(albuquerque, santaFe, 61).road(atlanta, macon, 82). road(atlanta, chattanooga, 117).road(augusta, charlotte, 161).  road(augusta, savannah, 131).road(austin, houston, 186).  road(austin, sanAntonio, 79).road(bakersfield, losAngeles, 112).  road(bakersfield, fresno, 107).road(baltimore, philadelphia, 102).  road(baltimore, washington, 45).road(batonRouge, lafayette, 50).  road(batonRouge, newOrleans, 80).road(beaumont, houston, 69).  road(beaumont, lafayette, 122).road(boise, saltLakeCity, 349). road(boise, portland, 428).road(boston, providence, 51).road(buffalo, toronto, 105). road(buffalo, rochester, 64).  road(buffalo, cleveland, 191).road(calgary, vancouver, 605).  road(calgary, winnipeg, 829).road(charlotte, greensboro, 91).road(chattanooga, nashville, 129).road(chicago, milwaukee, 90).  road(chicago, midland, 279).road(cincinnati, indianapolis, 110).  road(cincinnati, dayton, 56).road(cleveland, pittsburgh, 157).  road(cleveland, columbus, 142).road(coloradoSprings, denver, 70).  road(coloradoSprings, santaFe, 316).road(columbus, dayton, 72).road(dallas, denver, 792).  road(dallas, mexia, 83).road(daytonaBeach, jacksonville, 92).  road(daytonaBeach, orlando, 54).road(denver, wichita, 523).  road(denver, grandJunction, 246).road(desMoines, omaha, 135).  road(desMoines, minneapolis, 246).road(elPaso, sanAntonio, 580). road(elPaso, tucson, 320).road(eugene, salem, 63).  road(eugene, medford, 165).road(europe, philadelphia, 3939).road(ftWorth, oklahomaCity, 209).road(fresno, modesto, 109).road(grandJunction, provo, 220).road(greenBay, minneapolis, 304). road(greenBay, milwaukee, 117).road(greensboro, raleigh, 74).road(houston, mexia, 165).road(indianapolis, stLouis, 246).road(jacksonville, savannah, 140).  road(jacksonville, lakeCity, 113).road(japan, pointReyes, 5131).  road(japan, sanLuisObispo, 5451).road(kansasCity, tulsa, 249).  road(kansasCity, stLouis, 256). road(kansasCity, wichita, 190).road(keyWest, tampa, 446).road(lakeCity, tampa, 169).  road(lakeCity, tallahassee, 104).road(laredo, sanAntonio, 154). road(laredo, mexico, 741).road(lasVegas, losAngeles, 275).  road(lasVegas, saltLakeCity, 486).road(lincoln, wichita, 277).  road(lincoln, omaha, 58).road(littleRock, memphis, 137). road(littleRock, tulsa, 276).road(losAngeles, sanDiego, 124).  road(losAngeles, sanLuisObispo, 182).road(medford, redding, 150).road(memphis, nashville, 210).road(miami, westPalmBeach, 67).road(midland, toledo, 82).road(minneapolis, winnipeg, 463).road(modesto, stockton, 29).road(montreal, ottawa, 132).road(newHaven, providence, 110).  road(newHaven, stamford, 92).road(newOrleans, pensacola, 268).road(newYork, philadelphia, 101).road(norfolk, richmond, 92).  road(norfolk, raleigh, 174).road(oakland, sanFrancisco, 8). road(oakland, sanJose, 42).road(oklahomaCity, tulsa, 105).road(orlando, westPalmBeach, 168). road(orlando, tampa, 84).road(ottawa, toronto, 269).road(pensacola, tallahassee, 120).road(philadelphia, pittsburgh, 319). road(philadelphia, newYork, 101). road(philadelphia, uk1, 3548).road(philadelphia, uk2, 3548).road(phoenix, tucson, 117).  road(phoenix, yuma, 178).road(pointReyes, redding, 215).  road(pointReyes, sacramento, 115).road(portland, seattle, 174).  road(portland, salem, 47).road(reno, saltLakeCity, 520).  road(reno, sacramento, 133).road(richmond, washington, 105).road(sacramento, sanFrancisco, 95).  road(sacramento, stockton, 51).road(salinas, sanJose, 31).  road(salinas, sanLuisObispo, 137).road(sanDiego, yuma, 172).road(saultSteMarie, thunderBay, 442).  road(saultSteMarie, toronto, 436).road(seattle, vancouver, 115).road(thunderBay, winnipeg, 440)";
	TreeSet<String> nodes=new TreeSet<String>();	
	String spl[]=USA.split("\\.");
	//System.out.println(spl.length);
	for(String temp:spl)
	{
		String first_city=temp.substring(temp.indexOf('(')+1,temp.indexOf(','));
		String sc[]=temp.split(",");
		String second_city=sc[1].trim();
		nodes.add(first_city);
		nodes.add(second_city);
		
	}
	//System.out.println(nodes);
	//System.out.println(nodes.size());
	
	int edges[][]=new int[113][113];
	Iterator<String> i=nodes.iterator();
	LinkedList<String> nodeslist=new LinkedList<String>();
//	TreeMap<String,Boolean> explored=new TreeMap<String,Boolean>();
	
	while(i.hasNext())
	{
		String element=i.next();
		nodeslist.add(element);
		
	}
	
//	int n[][]=new int[21][21];
	for(int it=0;it<=112;it++)
		for(int j=0;j<=112;j++)
		edges[it][j]=0;
	
	for(String temp:spl)
	{
		String first_city=temp.substring(temp.indexOf('(')+1,temp.indexOf(','));
		int index1=nodeslist.indexOf(first_city);
		String sc[]=temp.split(",");
		String second_city=sc[1].trim();
		int index2=nodeslist.indexOf(second_city);
		int weight=Integer.parseInt(sc[2].substring(0,sc[2].indexOf(')')).trim());
		//int weight=Integer.parseInt(sc[2].trim());
		edges[index1+1][index2+1]=edges[index2+1][index1+1]=weight;
	}
	/*
	for(int it=0;it<=112;it++)
	{
		for(int j=0;j<=112;j++)
		System.out.print(edges[it][j]+" ");
		System.out.println();
	}	
		*/
	
	
	String coord="city(albanyGA,        31.58,  84.17).city(albanyNY,        42.66,  73.78).city(albuquerque,     35.11, 106.61).city(atlanta,         33.76,  84.40).city(augusta,         33.43,  82.02).city(austin,          30.30,  97.75).city(bakersfield,     35.36, 119.03).city(baltimore,       39.31,  76.62).city(batonRouge,      30.46,  91.14).city(beaumont,        30.08,  94.13).city(boise,           43.61, 116.24).city(boston,          42.32,  71.09).city(buffalo,         42.90,  78.85).city(calgary,         51.00, 114.00).city(charlotte,       35.21,  80.83).city(chattanooga,     35.05,  85.27).city(chicago,         41.84,  87.68).city(cincinnati,      39.14,  84.50).city(cleveland,       41.48,  81.67).city(coloradoSprings, 38.86, 104.79).city(columbus,        39.99,  82.99).city(dallas,          32.80,  96.79).city(dayton,          39.76,  84.20).city(daytonaBeach,    29.21,  81.04).city(denver,          39.73, 104.97).city(desMoines,       41.59,  93.62).city(elPaso,          31.79, 106.42).city(eugene,          44.06, 123.11).city(europe,          48.87,  -2.33).city(ftWorth,         32.74,  97.33).city(fresno,          36.78, 119.79).city(grandJunction,   39.08, 108.56).city(greenBay,        44.51,  88.02).city(greensboro,      36.08,  79.82).city(houston,         29.76,  95.38).city(indianapolis,    39.79,  86.15).city(jacksonville,    30.32,  81.66).city(japan,           35.68, 220.23).city(kansasCity,      39.08,  94.56).city(keyWest,         24.56,  81.78).city(lafayette,       30.21,  92.03).city(lakeCity,        30.19,  82.64).city(laredo,          27.52,  99.49).city(lasVegas,        36.19, 115.22).city(lincoln,         40.81,  96.68).city(littleRock,      34.74,  92.33).city(losAngeles,      34.03, 118.17).city(macon,           32.83,  83.65).city(medford,         42.33, 122.86).city(memphis,         35.12,  89.97).city(mexia,           31.68,  96.48).city(mexico,          19.40,  99.12).city(miami,           25.79,  80.22).city(midland,         43.62,  84.23).city(milwaukee,       43.05,  87.96).city(minneapolis,     44.96,  93.27).city(modesto,         37.66, 120.99).city(montreal,        45.50,  73.67).city(nashville,       36.15,  86.76).city(newHaven,        41.31,  72.92).city(newOrleans,      29.97,  90.06).city(newYork,         40.70,  73.92).city(norfolk,         36.89,  76.26).city(oakland,         37.80, 122.23).city(oklahomaCity,    35.48,  97.53).city(omaha,           41.26,  96.01).city(orlando,         28.53,  81.38).city(ottawa,          45.42,  75.69).city(pensacola,       30.44,  87.21).city(philadelphia,    40.72,  76.12).city(phoenix,         33.53, 112.08).city(pittsburgh,      40.40,  79.84).city(pointReyes,      38.07, 122.81).city(portland,        45.52, 122.64).city(providence,      41.80,  71.36).city(provo,           40.24, 111.66).city(raleigh,         35.82,  78.64).city(redding,         40.58, 122.37).city(reno,            39.53, 119.82).city(richmond,        37.54,  77.46).city(rochester,       43.17,  77.61).city(sacramento,      38.56, 121.47).city(salem,           44.93, 123.03).city(salinas,         36.68, 121.64).city(saltLakeCity,    40.75, 111.89).city(sanAntonio,      29.45,  98.51).city(sanDiego,        32.78, 117.15).city(sanFrancisco,    37.76, 122.44).city(sanJose,         37.30, 121.87).city(sanLuisObispo,   35.27, 120.66).city(santaFe,         35.67, 105.96).city(saultSteMarie,   46.49,  84.35).city(savannah,        32.05,  81.10).city(seattle,         47.63, 122.33).city(stLouis,         38.63,  90.24).city(stamford,        41.07,  73.54).city(stockton,        37.98, 121.30).city(tallahassee,     30.45,  84.27).city(tampa,           27.97,  82.46).city(thunderBay,      48.38,  89.25).city(toledo,          41.67,  83.58).city(toronto,         43.65,  79.38).city(tucson,          32.21, 110.92).city(tulsa,           36.13,  95.94).city(uk1,             51.30,   0.00).city(uk2,             51.30,   0.00).city(vancouver,       49.25, 123.10).city(washington,      38.91,  77.01).city(westPalmBeach,   26.71,  80.05).city(wichita,         37.69,  97.34).city(winnipeg,        49.90,  97.13).city(yuma,            32.69, 114.62)";
	double coordinates[][]=new double[113][2];
	
	String hspl[]=coord.split("\\.c");
	//System.out.println(hspl.length);
	
	for(String temp:hspl)
	{
		String city=temp.substring(temp.indexOf('(')+1,temp.indexOf(','));
		String latlon[]=temp.split(",");
		double lat=Double.parseDouble(latlon[1].trim());
		double lon=Double.parseDouble(latlon[2].substring(0,latlon[2].indexOf(')')).trim());
		
//		double lon=Double.parseDouble(latlon[2].trim());
		
		int indexc = nodeslist.indexOf(city);
		coordinates[indexc+1][0]=lat;
		coordinates[indexc+1][1]=lon;
		//System.out.print(lat+" "+lon);
		//System.out.println();
	}
	
	
	String searchtype=args[0];
	String srccity=args[1];
	String destcity=args[2];
	
	
	
	if(searchtype.equals("astar"))
	{
		LinkedList<String> paths=new LinkedList<String>();
		LinkedList<String> exploredlist=new LinkedList<String>();
		LinkedList<String> visitedlist=new LinkedList<String>();
		
		PriorityQueue<frontierq> fq = new PriorityQueue<frontierq>();
		//LinkedList<LinkedList<String>> frontier=new LinkedList<LinkedList<String>>();
		paths.add(srccity);
		//exploredlist.add(srccity);

		//visitedlist.add(srccity);
		
		int insrc=nodeslist.indexOf(srccity);
		int indest=nodeslist.indexOf(destcity);
		double Lat1=coordinates[insrc+1][0];
		double Long1=coordinates[insrc+1][1];
		
		double Lat2=coordinates[indest+1][0];
		double Long2=coordinates[indest+1][1];
		
		double heuristic_src_dest=Math.sqrt(Math.pow((69.5 * (Lat1 - Lat2)),2) + Math.pow((69.5 * Math.cos((Lat1 + Lat2)/360 * (22/7)) * (Long1 - Long2)),2));
		//System.out.println(heuristic_src_dest);
		
		
		HashMap<String,Double> frontierpathcosts=new HashMap<String,Double>();
		HashMap<String,Double> actualpathcostfromsource=new HashMap<String,Double>();
		fq.add(new frontierq(paths,heuristic_src_dest));
		frontierpathcosts.put(srccity,heuristic_src_dest);
		actualpathcostfromsource.put(srccity,new Double(0));
		while(true)
		{
			///*----------------- to see the expansion of search space uncomment the below line---------*/
			//System.out.println(frontier);
			
			if(fq.peek()==null)
			{	System.out.println("no solution");
				System.exit(0);
			}	
				
				 
				//  In order to view the contents of the priority queue during each iteration uncomment this
				 
				 /*
				 PriorityQueue<frontierq> temp= new PriorityQueue<frontierq>(fq);
				
				System.out.println("-------------------------------------------------");
				while(temp.peek()!=null)
					System.out.println(temp.peek().getpath()+"	"+actualpathcostfromsource.get(temp.peek().getpath().getLast())+"	"+temp.poll().getcost());
				
				System.out.println("------------------------------------------------");
				*/
				LinkedList<String> exppath=fq.peek().getpath();
				
				double cost=fq.poll().getcost();
				//System.out.println(exppath+"	"+cost);
				if(exploredlist.indexOf(exppath.getLast())==-1)
					exploredlist.add(exppath.getLast()); /*this line*/
				else continue;
				if(exppath.getLast().equals(destcity))
				{	
					if(actualpathcostfromsource.get(destcity)!=null)
						if(actualpathcostfromsource.get(destcity)==cost)
						{		
					System.out.println("found");
					System.out.println("path"+exppath);
					System.out.println("path length"+exppath.size());
//					System.out.println(actualpathcostfromsource.get(destcity)+"   "+frontierpathcosts.get(destcity));
					System.out.println("cost"+cost);
					System.out.println("number of expanded nodes:"+exploredlist.size());
					System.out.println("expandednodes"+exploredlist);
					
					System.exit(0);
						}
				}
				
				int expnodeindex=nodeslist.indexOf(exppath.getLast());
				//LinkedList<String> children=new LinkedList<String>();
				for(int f=1;f<=112;f++)
					if(edges[expnodeindex+1][f]>0)
					{
						//children.add(nodeslist.get(f-1));
						String child=nodeslist.get(f-1);
						if(exploredlist.indexOf(child)==-1 && visitedlist.indexOf(child)==-1)
						{	
							//{if(child.equals(destcity))
							//{
							//	System.out.println("found"+exploredlist);
							//	System.exit(0);
							//	}
							//exploredlist.add(child);
							visitedlist.add(child);
							LinkedList<String> newchildpath=new LinkedList<String>(exppath);
							newchildpath.addLast(child);
							double weight=edges[expnodeindex+1][f];
							double actual_path_cost= actualpathcostfromsource.get(exppath.getLast());
							double gn=actual_path_cost+weight;
							Lat1=coordinates[f][0];
							Long1=coordinates[f][1];
							double heuristic_cost=Math.sqrt(Math.pow((69.5 * (Lat1 - Lat2)),2) + Math.pow((69.5 * Math.cos((Lat1 + Lat2)/360 * (22/7)) * (Long1 - Long2)),2));
							
							double hn=heuristic_cost;
							double fn=gn+hn;
							
							fq.add(new frontierq(newchildpath,fn));
							actualpathcostfromsource.put(child,gn);
							frontierpathcosts.put(child,fn);
						}
						else if(exploredlist.indexOf(child)==-1)
						{	
							double oldcost=frontierpathcosts.get(child);
							double weight=edges[expnodeindex+1][f];
							double actual_path_cost= actualpathcostfromsource.get(exppath.getLast());
							double gn=actual_path_cost+weight;
							Lat1=coordinates[f][0];
							Long1=coordinates[f][1];
							double heuristic_cost=Math.sqrt(Math.pow((69.5 * (Lat1 - Lat2)),2) + Math.pow((69.5 * Math.cos((Lat1 + Lat2)/360 * (22/7)) * (Long1 - Long2)),2));
							
							double hn=heuristic_cost;
							double fn=gn+hn;
							/*
							System.out.println("src path cost"+actual_path_cost);
							System.out.println("weight"+weight);
							System.out.println("h"+heuristic_cost);
							System.out.println(oldcost+"	"+fn);
							*/
							if(fn<oldcost)
							{	frontierpathcosts.put(child,fn);
								actualpathcostfromsource.put(child,gn);
								LinkedList<String> newchildpath=new LinkedList<String>(exppath);
								newchildpath.addLast(child);
								fq.add(new frontierq(newchildpath,fn));
							}
						}
						
					}
					
			
		}
	}
	
	if(searchtype.equals("greedy"))
	{
		LinkedList<String> paths=new LinkedList<String>();
		LinkedList<String> exploredlist=new LinkedList<String>();
		LinkedList<String> visitedlist=new LinkedList<String>();
		
		PriorityQueue<frontierq> fq = new PriorityQueue<frontierq>();
		//LinkedList<LinkedList<String>> frontier=new LinkedList<LinkedList<String>>();
		paths.add(srccity);
		//exploredlist.add(srccity);

		//visitedlist.add(srccity);
		
		int insrc=nodeslist.indexOf(srccity);
		int indest=nodeslist.indexOf(destcity);
		double Lat1=coordinates[insrc+1][0];
		double Long1=coordinates[insrc+1][1];
		
		double Lat2=coordinates[indest+1][0];
		double Long2=coordinates[indest+1][1];
		
		double heuristic_src_dest=Math.sqrt(Math.pow((69.5 * (Lat1 - Lat2)),2) + Math.pow((69.5 * Math.cos((Lat1 + Lat2)/360 * (22/7)) * (Long1 - Long2)),2));
		//System.out.println(heuristic_src_dest);
		
		
		HashMap<String,Double> frontierpathcosts=new HashMap<String,Double>();
		HashMap<String,Double> actualpathcostfromsource=new HashMap<String,Double>();
		fq.add(new frontierq(paths,heuristic_src_dest));
		frontierpathcosts.put(srccity,heuristic_src_dest);
		actualpathcostfromsource.put(srccity,new Double(0));
		while(true)
		{
			///*----------------- to see the expansion of search space uncomment the below line---------*/
			//System.out.println(frontier);
//			 *  In order to view the contents of the priority queue during each iteration uncomment this
			 
			 /*
			 PriorityQueue<frontierq> temp= new PriorityQueue<frontierq>(fq);
			
			System.out.println("-------------------------------------------------");
			while(temp.peek()!=null)
				System.out.println(temp.peek().getpath()+"	"+actualpathcostfromsource.get(temp.peek().getpath().getLast())+"	"+temp.poll().getcost());
			
			System.out.println("------------------------------------------------");
*/
			
			if(fq.peek()==null)
			{	System.out.println("no solution");
				System.exit(0);
			}	
			
				LinkedList<String> exppath=fq.peek().getpath();
				
				double cost=fq.poll().getcost();
				//System.out.println(exppath+"	"+cost);
				if(exploredlist.indexOf(exppath.getLast())==-1)
				exploredlist.add(exppath.getLast()); /*this line*/
				else continue;
				if(exppath.getLast().equals(destcity))
				{	
					System.out.println("found");
					System.out.println("path"+exppath);
					System.out.println("path length"+exppath.size());
					System.out.println("path cost from source"+actualpathcostfromsource.get(destcity));
					//System.out.println("cost"+cost);
					System.out.println("number of expanded nodes:"+exploredlist.size());
					System.out.println("expandednodes"+exploredlist);
					
					System.exit(0);
					
				}
				
				int expnodeindex=nodeslist.indexOf(exppath.getLast());
				//LinkedList<String> children=new LinkedList<String>();
				for(int f=1;f<=112;f++)
					if(edges[expnodeindex+1][f]>0)
					{
						//children.add(nodeslist.get(f-1));
						String child=nodeslist.get(f-1);
						if(exploredlist.indexOf(child)==-1 && visitedlist.indexOf(child)==-1)
						{	
							//{if(child.equals(destcity))
							//{
							//	System.out.println("found"+exploredlist);
							//	System.exit(0);
							//	}
							//exploredlist.add(child);
							visitedlist.add(child);
							LinkedList<String> newchildpath=new LinkedList<String>(exppath);
							newchildpath.addLast(child);
							double weight=edges[expnodeindex+1][f];
							double actual_path_cost= actualpathcostfromsource.get(exppath.getLast());
							double gn=actual_path_cost+weight;
							Lat1=coordinates[f][0];
							Long1=coordinates[f][1];
							double heuristic_cost=Math.sqrt(Math.pow((69.5 * (Lat1 - Lat2)),2) + Math.pow((69.5 * Math.cos((Lat1 + Lat2)/360 * (22/7)) * (Long1 - Long2)),2));
							
							double hn=heuristic_cost;
							double fn=hn;
							
							fq.add(new frontierq(newchildpath,fn));
							actualpathcostfromsource.put(child,gn);
							frontierpathcosts.put(child,fn);
						}
						else if(exploredlist.indexOf(child)==-1)
						{	
							System.out.println("i reached here");
							double oldcost=frontierpathcosts.get(child);
							double weight=edges[expnodeindex+1][f];
							double actual_path_cost= actualpathcostfromsource.get(exppath.getLast());
							double gn=actual_path_cost+weight;
							Lat1=coordinates[f][0];
							Long1=coordinates[f][1];
							double heuristic_cost=Math.sqrt(Math.pow((69.5 * (Lat1 - Lat2)),2) + Math.pow((69.5 * Math.cos((Lat1 + Lat2)/360 * (22/7)) * (Long1 - Long2)),2));
							
							double hn=heuristic_cost;
							double fn=hn;
							if(fn<oldcost)
							{	frontierpathcosts.put(child,fn);
								actualpathcostfromsource.put(child,gn);
								LinkedList<String> newchildpath=new LinkedList<String>(exppath);
								newchildpath.addLast(child);
								fq.add(new frontierq(newchildpath,fn));
							}
						}
						
					}
					
			
		}
	}
	
	if(searchtype.equals("uniform"))
	{
		LinkedList<String> paths=new LinkedList<String>();
		LinkedList<String> exploredlist=new LinkedList<String>();
		LinkedList<String> visitedlist=new LinkedList<String>();
		
		PriorityQueue<frontierq> fq = new PriorityQueue<frontierq>();
		//LinkedList<LinkedList<String>> frontier=new LinkedList<LinkedList<String>>();
		paths.add(srccity);
		//exploredlist.add(srccity);

		//visitedlist.add(srccity);
		/*
		int insrc=nodeslist.indexOf(srccity);
		int indest=nodeslist.indexOf(destcity);
		double Lat1=coordinates[insrc+1][0];
		double Long1=coordinates[insrc+1][1];
		
		double Lat2=coordinates[indest+1][0];
		double Long2=coordinates[indest+1][1];
		
		double heuristic_src_dest=Math.sqrt(Math.pow((69.5 * (Lat1 - Lat2)),2) + Math.pow((69.5 * Math.cos((Lat1 + Lat2)/360 * (22/7)) * (Long1 - Long2)),2));
		//System.out.println(heuristic_src_dest);
		*/
		
		HashMap<String,Double> frontierpathcosts=new HashMap<String,Double>();
		HashMap<String,Double> actualpathcostfromsource=new HashMap<String,Double>();
		fq.add(new frontierq(paths,new Double(0)));
		frontierpathcosts.put(srccity,new Double(0));
		actualpathcostfromsource.put(srccity,new Double(0));
		while(true)
		{
			///*----------------- to see the expansion of search space uncomment the below line---------*/
			//System.out.println(frontier);
			if(fq.peek()==null)
			{	System.out.println("no solution");
				System.exit(0);
			}	
			
				LinkedList<String> exppath=fq.peek().getpath();
				
				double cost=fq.poll().getcost();
				//System.out.println(exppath+"	"+cost);
				if(exploredlist.indexOf(exppath.getLast())==-1)
					exploredlist.add(exppath.getLast()); /*this line*/
				else continue;
				if(exppath.getLast().equals(destcity))
				{	
					System.out.println("found");
					System.out.println("path"+exppath);
					System.out.println("path length"+exppath.size());
//					System.out.println(actualpathcostfromsource.get(destcity)+"   "+frontierpathcosts.get(destcity));
					System.out.println("cost"+cost);
					System.out.println("number of expanded nodes:"+exploredlist.size());
					System.out.println("expandednodes"+exploredlist);
					
					System.exit(0);
						
				}
				
				int expnodeindex=nodeslist.indexOf(exppath.getLast());
				//LinkedList<String> children=new LinkedList<String>();
				for(int f=1;f<=112;f++)
					if(edges[expnodeindex+1][f]>0)
					{
						//children.add(nodeslist.get(f-1));
						String child=nodeslist.get(f-1);
						if(exploredlist.indexOf(child)==-1 && visitedlist.indexOf(child)==-1)
						{	
							//{if(child.equals(destcity))
							//{
							//	System.out.println("found"+exploredlist);
							//	System.exit(0);
							//	}
							//exploredlist.add(child);
							visitedlist.add(child);
							LinkedList<String> newchildpath=new LinkedList<String>(exppath);
							newchildpath.addLast(child);
							double weight=edges[expnodeindex+1][f];
							double actual_path_cost= actualpathcostfromsource.get(exppath.getLast());
							double gn=actual_path_cost+weight;
							//Lat1=coordinates[f][0];
							//Long1=coordinates[f][1];
							//double heuristic_cost=Math.sqrt(Math.pow((69.5 * (Lat1 - Lat2)),2) + Math.pow((69.5 * Math.cos((Lat1 + Lat2)/360 * (22/7)) * (Long1 - Long2)),2));
							
							//double hn=heuristic_cost;
							double fn=gn;
							
							fq.add(new frontierq(newchildpath,fn));
							actualpathcostfromsource.put(child,gn);
							frontierpathcosts.put(child,fn);
						}
						else if(visitedlist.indexOf(child)!=-1 && exploredlist.indexOf(child)==-1)
						{
							double oldcost=frontierpathcosts.get(child);
							double weight=edges[expnodeindex+1][f];
							double actual_path_cost= actualpathcostfromsource.get(exppath.getLast());
							double gn=actual_path_cost+weight;
							//Lat1=coordinates[f][0];
							//Long1=coordinates[f][1];
							//double heuristic_cost=Math.sqrt(Math.pow((69.5 * (Lat1 - Lat2)),2) + Math.pow((69.5 * Math.cos((Lat1 + Lat2)/360 * (22/7)) * (Long1 - Long2)),2));
							
							//double hn=heuristic_cost;
							double fn=gn;
							if(fn<oldcost)
							{	frontierpathcosts.put(child,fn);
								actualpathcostfromsource.put(child,gn);
								LinkedList<String> newchildpath=new LinkedList<String>(exppath);
								newchildpath.addLast(child);
								fq.add(new frontierq(newchildpath,fn));
							}
						}
						
					}
					
			
		}
	}
	
	
	
	
	
	
	
	
	
	
//	

}


 static class frontierq implements Comparable<frontierq> {

    private LinkedList<String> path;
    private double cost;

    public frontierq(LinkedList path, double cost) {
        this.path = path;
        this.cost = cost;
    }

    public LinkedList getpath() {
        return path;
    }

    public double getcost() {
        return cost;
    }

/*        @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final frontierq other = (frontierq) obj;
        if ((this.path == null) ? (other.path != null) : !this.path.equals(other.path)) {
            return false;
        }
        if (this.cost != other.cost) {
            return false;
        }
        return true;
    }

*/
    public int compareTo(frontierq i) {
       /* if (this.price == i.price) {
            return this.path.compareTo(i.path);
        }
*/
        if((this.cost - i.cost)<0)
        	return -1;
        else if((this.cost-i.cost)>0)
        	return 1;
        else return 0;
    }

          public String toString() {
        return String.format("%s: $%d", path, cost);
    }      
  
}




}
