//
//  FilledCircleShape.java
//  guiserver
//
//  Created by Lutz Mueller on 6/24/07.
//
//
//    Copyright (C) 2008 Lutz Mueller
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
//


import java.lang.*;
import java.awt.*;
import java.awt.color.*;
import java.awt.geom.*;
import java.util.*;


@SuppressWarnings("unchecked")
public class FilledCircleShape extends Shape {

int radius;

public FilledCircleShape(StringTokenizer tokens)
	{
	tag = tokens.nextToken();
	X = Integer.parseInt(tokens.nextToken());
	Y = Integer.parseInt(tokens.nextToken());
	radius = Integer.parseInt(tokens.nextToken());
	
	if(tokens.hasMoreTokens())
		paintColor = Shape.getColorParameter(tokens);
	else
		paintColor = CanvasWidget.currentCanvas.currentPaint;
	
	stroke = CanvasWidget.currentCanvas.currentStroke;
	
	CanvasWidget.currentCanvas.drawobjects.add(this);
	}
	
public void drawShape(Graphics2D g2)
	{
	g2.setStroke(stroke);
	g2.setPaint(paintColor);
	//g2.setComposite(currentComposite);
	g2.fillOval(X - radius, Y - radius, 2 * radius - 1, 2 * radius - 1);
	}
	
public boolean hasPoint(int x, int y)
	{
	return(new Rectangle(X - radius, Y - radius, 2 * radius, 2 * radius).contains(x, y));
	}

}
 
 
// eof //
