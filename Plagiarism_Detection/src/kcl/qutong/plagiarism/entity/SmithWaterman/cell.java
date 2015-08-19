package kcl.qutong.plagiarism.entity.SmithWaterman;

public class cell extends point{
point[] parents;
point[] pre_dominated;
point[] post_dominated;
int x;//x-coordinate index of x
int y;
int value;
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public point[] getParents() {
	return parents;
}
public void setParents(point[] parents) {
	this.parents = parents;
}
public point[] getPre_dominated() {
	return pre_dominated;
}
public void setPre_dominated(point[] pre_dominated) {
	this.pre_dominated = pre_dominated;
}
public point[] getPost_dominated() {
	return post_dominated;
}
public void setPost_dominated(point[] post_dominated) {
	this.post_dominated = post_dominated;
}public cell(){
	super();
}
}
