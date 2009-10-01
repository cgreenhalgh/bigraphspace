package bigraph.biged.ui.graph.parts;

import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transposer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;

public abstract class BigraphLayoutEditPolicy extends FlowLayoutEditPolicy
{
	protected abstract Command createCloneCommand(EditPart child, EditPart before);

	protected abstract Command createOrphanChildCommand(final EditPart child);

	@SuppressWarnings("unchecked")
	@Override
	protected Command getCloneCommand(final ChangeBoundsRequest request)
	{
		final List<EditPart> editParts = request.getEditParts();
		final CompoundCommand command = new CompoundCommand();
		for (final EditPart child : editParts)
		{
			command.add(createCloneCommand(child, getInsertionReference(request)));
		}
		return command.unwrap();
	}

	/**
	 * @see OrderedLayoutEditPolicy#getInsertionReference(Request)
	 */
	@Override
	protected EditPart getInsertionReference(final Request request)
	{
		final int index = getFeedbackIndexFor(request);
		if (index >= getHost().getChildren().size()) { return null; }
		return super.getInsertionReference(request);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Command getOrphanChildrenCommand(final Request request)
	{
		final Collection<EditPart> parts = ((GroupRequest) request).getEditParts();
		if (parts.size() == 0) { return null; }

		final CompoundCommand command = new CompoundCommand("Orphan Children");
		for (final EditPart part : parts)
		{
			command.add(createOrphanChildCommand(part));
		}
		if (command.isEmpty()) { return null; }
		return command.unwrap();
	}

	@Override
	protected void showLayoutTargetFeedback(final Request request)
	{
		if (getHost().getChildren().size() == 0) { return; }
		int epIndex = getFeedbackIndexFor(request);
		if (epIndex == -1) { return; }
		final Polyline fb = getLineFeedback();
		final Transposer transposer = new Transposer();
		transposer.setEnabled(!isHorizontal());

		boolean before = true;
		Rectangle r = null;
		if (epIndex >= getHost().getChildren().size())
		{
			before = false;
			epIndex = getHost().getChildren().size() - 1;
		}
		final EditPart editPart = (EditPart) getHost().getChildren().get(epIndex);
		r = transposer.t(getAbsoluteBounds((GraphicalEditPart) editPart));

		int x = Integer.MIN_VALUE;
		if (before)
		{
			/*
			 * Want the line to be halfway between the end of the previous and the beginning of this
			 * one. If at the beginning of a line, then start halfway between the left edge of the
			 * parent and the beginning of the box, but no more than 5 pixels (it would be too far
			 * and be confusing otherwise).
			 */
			if (epIndex > 0)
			{
				// Need to determine if a line break.
				final Rectangle boxPrev = transposer.t(getAbsoluteBounds((GraphicalEditPart) getHost().getChildren()
						.get(epIndex - 1)));
				final int prevRight = boxPrev.right();
				if (prevRight < r.x)
				{
					// Not a line break
					x = prevRight + (r.x - prevRight) / 2;
				}
				else if (prevRight == r.x)
				{
					x = prevRight + 1;
				}
			}
			if (x == Integer.MIN_VALUE)
			{
				// It is a line break.
				final Rectangle parentBox = transposer.t(getAbsoluteBounds((GraphicalEditPart) getHost()));
				x = r.x - 5;
				if (x < parentBox.x)
				{
					x = parentBox.x + (r.x - parentBox.x) / 2;
				}
			}
		}
		else
		{
			/*
			 * We only have before==false if we are at the end of a line, so go halfway between the
			 * right edge and the right edge of the parent, but no more than 5 pixels.
			 */
			final Rectangle parentBox = transposer.t(getAbsoluteBounds((GraphicalEditPart) getHost()));
			final int rRight = r.x + r.width;
			final int pRight = parentBox.x + parentBox.width;
			x = rRight + 5;
			if (x > pRight)
			{
				x = rRight + (pRight - rRight) / 2;
			}
		}
		Point p1 = new Point(x, r.y - 4);
		p1 = transposer.t(p1);
		fb.translateToRelative(p1);
		Point p2 = new Point(x, r.y + r.height + 4);
		p2 = transposer.t(p2);
		fb.translateToRelative(p2);
		fb.setPoint(p1, 0);
		fb.setPoint(p2, 1);
	}

	private Rectangle getAbsoluteBounds(final GraphicalEditPart ep)
	{
		final Rectangle bounds = ep.getFigure().getBounds().getCopy();
		ep.getFigure().translateToAbsolute(bounds);
		return bounds;
	}
}