/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import blue.lapis.pore.converter.type.entity.EntityConverter;
import blue.lapis.pore.impl.entity.PoreThrownExpBottle;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.event.entity.ExpBottleEvent;
import org.spongepowered.api.event.entity.EntityEvent;

public class PoreExpBottleEvent extends ExpBottleEvent {

    private final EntityEvent handle;

    public PoreExpBottleEvent(EntityEvent handle) {
        super(null, -1);
        this.handle = checkNotNull(handle, "handle");
        checkState(handle.getEntity() instanceof org.spongepowered.api.entity.projectile.ThrownExpBottle,
                "Bad entity type");
    }

    public EntityEvent getHandle() {
        return this.handle;
    }

    @Override
    public ThrownExpBottle getEntity() {
        return (ThrownExpBottle) PoreThrownExpBottle.of(this.getHandle().getEntity());
    }

    @Override
    public EntityType getEntityType() {
        return EntityConverter.of(this.getHandle().getEntity().getType());
    }

    @Override
    public boolean getShowEffect() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setShowEffect(final boolean showEffect) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getExperience() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setExperience(final int exp) {
        throw new NotImplementedException("TODO");
    }
}
